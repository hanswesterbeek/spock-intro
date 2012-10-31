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
		given:
			// your code here
		when:
			def foo = null // your code here, remove this
		then:
			// your assertion here
			false // let the test fail for now
	}

	def "see if an even number yields correct result"(){
		given:
		// your code here
		when:
			def foo = null // your code here, remove this
		then:
		// your assertion here
		false // let the test fail for now
	}

	def "see that null values are not accepted"(){
		given:
			// your code here
		when:
			def foo = null // your code here, remove this
		then:
			// your assertion here
			false // let the test fail for now
	}
}
