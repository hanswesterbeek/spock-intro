package enhance.nlgug;

import java.util.List;

/**
 * @author Hans Westerbeek
 */
public interface ProductService {

	/**
	 *
	 * @param id
	 * @return null when the product was not found
	 */
	Product findProduct(Long id);

	/**
	 *
	 * @return
	 */
	List<Product> findAll();


	/**
	 *
	 * @param product
	 */
	void addProduct(Product product);

	/**
	 *
	 * @param productId
	 * @param quantity
	 * @return true when the product was sold
	 * @throws OutOfStockException when there is no more stock for this product
	 */
	void sell(Long productId, Integer quantity) throws OutOfStockException;

	void deleteProduct(Product product);
}
