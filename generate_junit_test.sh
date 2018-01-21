#!/bin/bash
echo "Generating Junit tests for java_programs:"

java -cp .:gson-2.8.1.jar:javawriter-2.5.1.jar junit_testcases.TestsGenerator