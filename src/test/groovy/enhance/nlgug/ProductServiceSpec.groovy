package enhance.nlgug

/**
 * @author Hans Westerbeek
 * Spec that demonstrates Spock's mocking capabilities
 */
class ProductServiceSpec {

	ProductService productService

	// its collabotators
	ProductRepository productRepository
	Emailer emailer;

	def setup(){

	}

	def "successfully add a product"(){

	}

	def "can not add a product with a name that already exists"(){

	}

	def "selling a product causes its stock to be updated"(){

	}

	def "an email about our product must be sent when has hit the stock limit"(){

	}

	def "deleting a product involves getting a token to be able to do so"(){

	}
}
