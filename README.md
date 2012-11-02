Demonstrates:

* the basic forms of Spock Tests
* mocking with Spock

Your goal: achieve 100% branch coverage on NumberServiceImpl and ProductServiceImpl.
How: implement NumberServiceSpec and ProductServiceSpec and adding all the appropriate assertions.

To run all tests, type:

	gradlew test

*After* that, if you want to check your progress on branch coverage, run:

	gradlew testCoberturaReport

Open the report in your browser: build/reports/cobertura/index.html

To see solutions, switch to the 'solutions' branch: 'git checkout solutions'. No cheating! :)

ABOUT SETTING UP YOUR IDE

Spock Tests are jUnit tests so they run fine in any IDE. However for the purposes of getting to know Spock, I advise not to bother with setting that up now. Instead, just use your favourite texteditor and the commandline to run them.

Eclipse setup: install the Groovy Eclipse plugin, and run 'gradle eclipse' and import the generated project to your workspace of choice

Intellij 11 can import Gradle projects, if you have an older version of IntelliJ, run 'gradle idea', and open the generated project.