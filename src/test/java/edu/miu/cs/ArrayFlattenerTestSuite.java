package edu.miu.cs;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Array Flattener Test Suite")
@SelectClasses({ ArrayFlattenerTest.class })
public class ArrayFlattenerTestSuite {}
