Purpose
========

This tutorial is an easy way to get started using [Spock Framework](http://www.spockframework.org). You will learn about:

* The basic forms of Spock Tests
* Spock's mocking framework

Prerequisites
==============
* Know Java, and don't be scared by Groovy (its learning curve is flat)
* Be aware of what makes a [good unit test](http://stackoverflow.com/questions/61400/what-makes-a-good-unit-test)
* Have a look at the [Spock reference documentation](http://docs.spockframework.org/en/latest/) and keep it handy

Steps for you to take
======================

* Set up your IDE, or just use your favourite text editor. IDE is not required (see below)
* Achieve 100% branch coverage on NumberServiceImpl and ProductServiceImpl by implementing NumberServiceSpec and ProductServiceSpec and adding all the appropriate assertions. You can find them in src/test/groovy/enhance/nlggug

To run what you have developed, cd to the project-root directory and type:

	./gradlew test

*After* that, if you want to check your progress on branch coverage, run:

	./gradlew testCoberturaReport

Open the report in your browser: build/reports/cobertura/index.html

To see solutions, switch to the 'solutions' branch: 'git checkout solutions'. No cheating! :)

Setting up your IDE
====================
Spock Tests are jUnit tests so they run fine in any IDE. However for the purposes of getting to know Spock, I advise not to bother with setting that up now. Instead, just use your favourite texteditor and the commandline to run them.

Eclipse setup: install the Groovy Eclipse plugin, and run 'gradle eclipse' and import the generated project to your workspace of choice

Intellij 11 can import Gradle projects, if you have an older version of IntelliJ, run 'gradle idea', and open the generated project.