package enhance.nlgug

import spock.lang.Specification

/**
 * @author Hans Westerbeek
 *
 * Demonstrates the different setups spock allows for a 'feature' test
 */

class AssertionStyleSpec extends Specification{

	def "given-when-then style"() {
		when:
		def x = Math.max(5, 9)

		then:
		x == 9
	}

	def "expect style"() {
		expect:
		Math.max(5, 9) == 9
	}

}
