package enhance.nlgug;

/**
 * @author Hans Westerbeek
 */
public class OutOfStockException extends Exception {

	private int stockLeft;

	public OutOfStockException(int stockLeft) {
		this.stockLeft = stockLeft;
	}
}
