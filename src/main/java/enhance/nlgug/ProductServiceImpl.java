package enhance.nlgug;


/**
 * @author Hans Westerbeek
 */
class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	private Emailer emailer;
	private AuthorizationService authorizationService;


	@Override
	public Product findProduct(Long id) {
		return productRepository.getProduct(id);
	}

	@Override
	public void addProduct(Product product) {

		// see if it already exists
		if (productRepository.findByName(product.getName()) == null){
			productRepository.addProduct(product);
		}

	}

	@Override
	public void sell(Long productId, Integer quantity) throws OutOfStockException{
		// completely un-threadsafe :)
		Product product = findProduct(productId);
		if (product == null)
			throw new IllegalArgumentException("You can't sell a product that does not exist");

		if (product.getStock() < quantity){
			this.emailer.sendOutOfStockEmail(product);
			throw new OutOfStockException(product.getStock());
		}

		product.setStock(product.getStock() - quantity);
	}

	@Override
	public void deleteProduct(Product product) {
		Integer token = authorizationService.acquireToken();
		// i know, this is a bit contrived :)
		productRepository.deleteProduct(product, token);
	}


}

