Demonstrates:

* the basic forms of Spock Tests
* mocking with Spock

Your goal: achieve 100% branch coverage by implementing NumberServiceSpec and ProductServiceSpec and adding all the appropriate assertions.

To run all tests, type:

	gradlew test

*After* that, if you want to check your progress on branch coverage, run:

	gradlew testCoberturaReport

Open the report in your browser: build/reports/cobertura/index.html

To see solutions, switch to the 'solutions' branch: 'git checkout solutions'. No cheating! :)

ABOUT SETIING UP YOUR IDE
Spock Tests are jUnit tests so they run fine in any IDE. However for the purposes of getting to know Spock, I advise not to bother with setting that up now. Instead, just use your favourite texteditor and the commandline to run them.