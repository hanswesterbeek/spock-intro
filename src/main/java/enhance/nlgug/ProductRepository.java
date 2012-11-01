package enhance.nlgug;

import java.util.List;

/**
 * @author Hans Westerbeek
 */
public interface ProductRepository {

	void addProduct(Product product);

	Product findByName(String name);

	Product getProduct(Long id);

	List<Product> findAll();

	void deleteProduct(Product product, Integer token);
}
