package edu.miu.cs;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Array Reversor Test Cases Suite")
@SelectClasses({ ArrayReversorTest.class })
public class ArrayReversorTestCases {
}