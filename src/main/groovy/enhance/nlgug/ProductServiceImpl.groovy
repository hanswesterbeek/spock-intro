package enhance.nlgug

import groovy.util.logging.Slf4j

/**
 * @author Hans Westerbeek
 */
@Slf4j
class ProductServiceImpl implements ProductService {

	def ProductRepository productRepository

	@Override
	Product findProduct(Long id) {
		log.debug("finding product ${id}")
		productRepository.products.find{it.id == id}
	}

	@Override
	List<Product> findAll() {
		productRepository.products
	}

	@Override
	void sell(Long productId, Integer quantity) throws OutOfStockException{
		// completely un-threadsafe :)
		Product product = findProduct(productId)
		if (product == null)
			throw new IllegalArgumentException("You can't sell a product that does not exist")

		if (product.stock < quantity)
			throw new OutOfStockException(product.stock)


		product.stock = product.stock - quantity
	}
}
