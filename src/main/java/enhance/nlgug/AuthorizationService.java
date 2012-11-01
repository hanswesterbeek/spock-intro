package enhance.nlgug;

/**
 * @author Hans Westerbeek
 */
public interface AuthorizationService {

	/**
	 *
	 * @return null when you have bad luck
	 */
	Integer acquireToken();
}
