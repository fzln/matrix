#!/bin/sh

cd out/production/matrix

java -cp .:../../../lib/junit-4.12.jar:../../../lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore\
 matrix.StringParserTest\
 matrix.CalculateArrayTest
