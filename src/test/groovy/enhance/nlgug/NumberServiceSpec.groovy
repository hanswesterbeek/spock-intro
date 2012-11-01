package enhance.nlgug

import spock.lang.Specification

/**
 * Spec that demonstrates that we can have pure java classes as unit under tests.
 * Other subject covered is asserting excepitions
 * @author Hans Westerbeek
 */
class NumberServiceSpec extends Specification {

	NumberService numberService // the unit under test

	def setup(){
		numberService = new NumberServiceImpl()
		// your code here

	}
	def "see if an odd number yields correct result"(){
		when:
			def result = numberService.isEven(1)
		then:
			!result
	}

	def "see if an even number yields correct result"(){
		when:
			def result = numberService.isEven(2)
		then:
			result
	}

	def "see that null values are not accepted"(){
		when:
			def result = numberService.isEven(null)
		then:
			thrown(IllegalArgumentException)
	}
}