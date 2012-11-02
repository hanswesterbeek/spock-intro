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

	def setup(){
		productRepository = Mock(ProductRepository)
		emailer = Mock(Emailer)

		productService = new ProductServiceImpl(productRepository: productRepository, emailer: emailer)

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

	}

	def "Selling a product causes its stock to be updated"(){
		given:
			def quantity = 3
		when:
			productService.sell(product.id, quantity)
		then:
			1 * productRepository.getProduct(product.id) >> {return product}
			product.stock == 7
	}

	def "An email about our product must be sent when has hit the stock limit"(){

	}

	def "Deleting a product involves getting a token to be able to do so"(){

	}
}
