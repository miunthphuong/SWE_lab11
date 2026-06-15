package edu.miu.cs;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayFlattenerTest {

    private ArrayFlattener flattener;

    @BeforeEach
    public void setUp() {
        flattener = new ArrayFlattener();
    }

    /**
     * Test Case A: Input is a legitimate 2-D nested array.
     */
    @Test
    public void testFlattenArray_LegitimateArray() {
        int[][] input = {{1, 3}, {0}, {4, 5, 9}};
        int[] expected = {1, 3, 0, 4, 5, 9};

        int[] actual = flattener.flattenArray(input);

        assertArrayEquals(expected, actual, "The 2D array was not flattened correctly.");
    }

    /**
     * Test Case B: Input is null.
     */
    @Test
    public void testFlattenArray_NullInput() {
        int[][] input = null;

        int[] actual = flattener.flattenArray(input);

        assertNull(actual, "The output should be null when the input is null.");
    }
}