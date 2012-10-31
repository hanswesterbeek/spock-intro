package enhance.nlgug;

/**
 * Very simple class that demonstrates that we can test Java classes
 * @author Hans Westerbeek
 *
 */
public class NumberServiceImpl implements NumberService{

	public boolean isEven(Integer number){

		if (number == null){
			throw new IllegalArgumentException("We dont know what to do with null");
		}

		return (number % 2 == 0);
	}
}
