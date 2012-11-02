package enhance.nlgug

/**
 * @author Hans Westerbeek
 * Spec that demonstrates Spock's mocking capabilities
 */
class ProductServiceSpec {

	ProductService productService

	// its collabotators
	ProductRepository productRepository
	Emailer emailer
	Product product

	def setup(){
		productRepository = Mock(ProductRepository)
		emailer = Mock(Emailer)

		productService = new ProductServiceImpl(productRepository: productRepository, emailer: emailer)

		product = new Product()
	}



	def "Retrieving a Product happens by using the id that you pass to the service "(){

	}

	def "Successfully add a product"(){


	}

	def "Can not add a product with a name that already exists"(){

	}

	def "Selling a product causes its stock to be updated"(){

	}

	def "An email about our product must be sent when has hit the stock limit"(){

	}

	def "Deleting a product involves getting a token to be able to do so"(){

	}
}
