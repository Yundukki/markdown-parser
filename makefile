.PHONY: test run

FILE ?=  test-file.md
CPATH=.:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar
TEST_ENTRYPOINT ?= org.junit.runner.JUnitCore

default: test

MarkdownParse.class: MarkdownParse.java
	javac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" MarkdownParse.java

MarkdownParseTest.class: MarkdownParse.class
	javac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.java

test: MarkdownParseTest.class
	java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar"org.junit.runner.JUnitCore MarkdownParseTest
	
clean: 
	rm -rf *.class

build: MarkdownParseTest.class

run: MarkdownParse.class
	java MarkdownParse test-file-3.md