package edu.miu.cs;

import java.util.Arrays;

public class ArrayFlattener {

    /**
     * Flattens a 2D array into a 1D array.
     * * @param nestedArray The 2D input array to flatten.
     * @return A 1D array containing all elements, or null if the input is null.
     */
    public int[] flattenArray(int[][] nestedArray) {
        if (nestedArray == null) {
            return null;
        }

        return Arrays.stream(nestedArray)
                .filter(row -> row != null) // Guard against null rows inside the 2D array
                .flatMapToInt(Arrays::stream)
                .toArray();
    }

    // Optional: Main method to run as a command-line application
    public static void main(String[] args) {
        ArrayFlattener flattener = new ArrayFlattener();

        int[][] input = {{1, 3}, {0}, {4, 5, 9}};
        int[] output = flattener.flattenArray(input);

        System.out.println("Input:  " + Arrays.deepToString(input));
        System.out.println("Output: " + Arrays.toString(output));
    }
}