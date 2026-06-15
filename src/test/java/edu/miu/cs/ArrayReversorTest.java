package edu.miu.cs;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayReversorTest {

    private ArrayReversor reversor;
    private ArrayFlattenerService flattenerService;

    // Global variables to hold stubbed data and track invocation count for verification
    private int[] mockStubbedOutput;
    private int invocationCount;

    @BeforeEach
    public void setUp() {
        // Reset the invocation counter and stubbed data before each test execution
        invocationCount = 0;
        mockStubbedOutput = null;

        // Manual mock implementation using an Anonymous Class to bypass JVM 21 bytecode agent restrictions
        flattenerService = new ArrayFlattenerService() {
            @Override
            public int[] flattenArray(int[][] nestedArray) {
                invocationCount++; // Increment the counter to verify the method invocation behavior
                return mockStubbedOutput; // Return the configured stubbed dataset
            }
        };

        // Inject the manual mock service dependency into the main component under test
        reversor = new ArrayReversor(flattenerService);
    }

    /**
     * Test Case a: Verifies behavior when the input is a legitimate 2-D nested array.
     */
    @Test
    public void testReverseArray_LegitimateArray() {
        int[][] input = {{1, 3}, {0}, {4, 5, 9}};

        // Define mock behavior: what the flattener service should return when invoked
        mockStubbedOutput = new int[]{1, 3, 0, 4, 5, 9};

        int[] expectedReversedOutput = {9, 5, 4, 0, 3, 1};

        // Execute the target method
        int[] actualOutput = reversor.reverseArray(input);

        // 1. Assert state verification: ensure the array elements are correctly flattened and reversed
        assertArrayEquals(expectedReversedOutput, actualOutput, "The array was not reversed correctly.");

        // 2. Assert behavior verification: ensure the remote service was actually invoked exactly 1 time
        assertEquals(1, invocationCount, "The ArrayFlattenerService should be invoked exactly once.");
    }

    /**
     * Test Case b: Verifies behavior when the input is null.
     */
    @Test
    public void testReverseArray_NullInput() {
        int[][] input = null;

        // Execute the target method with a null payload
        int[] actualOutput = reversor.reverseArray(input);

        // 1. Assert state verification: ensure that a null input returns a null output gracefully
        assertNull(actualOutput, "The output should be null when the input 2-D array is null.");

        // 2. Assert behavior verification: ensure the component handles the guard clause
        // and does not invoke the remote service at all when the input is invalid.
        assertEquals(0, invocationCount, "The ArrayFlattenerService should never be invoked when the input is null.");
    }
}