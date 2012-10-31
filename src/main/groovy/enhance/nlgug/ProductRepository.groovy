package enhance.nlgug

/**
 * @author Hans Westerbeek
 */
class ProductRepository {

	def products = []

	def getProducts(){
		products
	}

	def addProduct(Product product){
		products += product
	}
}
