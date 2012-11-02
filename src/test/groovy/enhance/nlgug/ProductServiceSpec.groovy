package enhance.nlgug

import spock.lang.Specification

/**
 * @author Hans Westerbeek
 * Spec that demonstrates Spock's mocking capabilities
 */
class ProductServiceSpec extends Specification {

	ProductService productService

	// its collabotators
	ProductRepository productRepository
	Emailer emailer
	Product product
	AuthorizationService authorizationService

	def setup(){
		productRepository = Mock(ProductRepository)
		emailer = Mock(Emailer)
		authorizationService = Mock(AuthorizationService)
		productService = new ProductServiceImpl(productRepository, emailer, authorizationService)
		product = new Product(id:  14, name: "foo", stock: 10)
	}



	def "Retrieving a Product happens by using the id that you pass to the service "(){
		when:
			def result = productService.findProduct(product.id)
		then:
			result == product
			1 * productRepository.getProduct(product.id) >> {return product}

	}

	def "Successfully add a product"(){
		when:
			productService.addProduct(product)
		then:
			1 * productRepository.findByName(product.name) >> { return null}
			1 * productRepository.addProduct(product)
	}

	def "Can not add a product with a name that already exists"(){
		when:
			productService.addProduct(product)
		then:
			1 * productRepository.findByName(product.name) >> { return new Product()} // we dont really care about the actual product returned
			0 * productRepository.addProduct(_) // that method may not have been invoked
	}

	def "we can not sell a product that is null"(){
		given:
			def unexistingId = 1
		when:
			productService.sell(unexistingId, 200)
		then:
			1 * productRepository.getProduct(unexistingId) >> {return null}
			thrown(IllegalArgumentException)
	}

	def "Selling a product causes its stock to be updated"(){
		given:
			def quantity = 3
			def originalStock = new Integer(product.stock)
		when:
			productService.sell(product.id, quantity)
		then:
			1 * productRepository.getProduct(product.id) >> {return product}
			product.stock == (originalStock - quantity)
	}

	def "An email about our product must be sent when has hit the stock limit"(){
		given:
			def originalStock = new Integer(product.stock)
		when:
			productService.sell(product.id, product.stock + 1)
		then:
			1 * productRepository.getProduct(product.id) >> {return product}
		thrown(OutOfStockException)
			1 * emailer.sendOutOfStockEmail(product)
			product.stock == originalStock
	}

	def "Deleting a product involves getting a token to be able to do so: let it fail"(){
		when:
			productService.deleteProduct(product)
		then:
			1 * authorizationService.acquireToken() // let it return null
			thrown(RuntimeException)
	}

	def "Deleting a product involves getting a token to be able to do so: let it succeed"(){
		given:
			def token = 1

		when:
			productService.deleteProduct(product)
		then:
			1 * authorizationService.acquireToken() >> { return token}
			1 * productRepository.deleteProduct(product, token)
	}

}
