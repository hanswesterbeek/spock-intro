package enhance.nlgug

import spock.lang.Specification

/**
 *
 * The comments in each method below tell you what you need to implement
 *
 * @author Hans Westerbeek
 *
 */
class ProductServiceSpec extends Specification {

	ProductService productService

	// its collabotators
	ProductRepository productRepository
	Emailer emailer
	AuthorizationService authorizationService

	def "Retrieving a Product happens by using the id that you pass to the service "(){
		// invoke productService.findProduct
		// check that the productRepository was invoked with the id as argument
	}

	def "Successfully add a product"(){
		// invoke productService.addProduct
		// assert that the call to productRepository.findByName() returns null
		// assert that the product you passed got passed to productRepository.addProduct()
	}

	def "Can not add a product with a name that already exists"(){
		// invoke productService.addProduct
		// mock the return of a Product object when productRepository.findByName() is invoked
		// assert that productRepository.addProduct was not invoked
	}

	def "we can not sell a product that is null"(){
		// invoke productService.sellProduct
		// mock that the call productRepository.getProduct() yields null
		// assert that an IllegalArgumentException was thrown
	}

	def "Selling a product causes its stock to be updated"(){
		// invoke productService.sellProduct
		// mock that the call productRepository.getProduct() yields the right product
		// assert that product.stock was updated
	}

	def "An email about our product must be sent when has hit the stock limit"(){
		// invoke productService.sellProduct
		// assert that OutOfStockException was thrown
		// mock that the call productRepository.getProduct() yields the right product
		// assert that emailer.sendOutOfStockEmail() was invoked
		// assert that product.stock was NOT updated
	}

	def "Deleting a product involves getting a token to be able to do so: let this fail"(){
		// invoke productService.deleteProduct()
		// let authorizationService.acquireToken() return null
		// assert that a RuntimeException was thrown
	}

	def "Deleting a product involves getting a token to be able to do so: let it succeed"(){
		// invoke productService.deleteProduct()
		// let a token be returned by authorizationService.acquireToken()
		// assert that this token was used when invoking productRepository.deleteProduct
	}
}
