package edu.miu.cs;

import java.util.Arrays;

public class ArrayReversor {

    private final ArrayFlattenerService flattenerService;

    public ArrayReversor(ArrayFlattenerService flattenerService) {
        this.flattenerService = flattenerService;
    }


    public int[] reverseArray(int[][] nestedArray) {
        if (nestedArray == null) {
            return null;
        }

        int[] flattened = flattenerService.flattenArray(nestedArray);

        if (flattened == null) {
            return null;
        }

        // 4. Logic đảo ngược mảng 1D
        int[] reversed = new int[flattened.length];
        for (int i = 0; i < flattened.length; i++) {
            reversed[i] = flattened[flattened.length - 1 - i];
        }

        return reversed;
    }

    public static void main(String[] args) {
        ArrayFlattenerService realService = nested -> Arrays.stream(nested).flatMapToInt(Arrays::stream).toArray();
        ArrayReversor reversor = new ArrayReversor(realService);

        int[][] input = {{1, 3}, {0}, {4, 5, 9}};
        int[] output = reversor.reverseArray(input);
        System.out.println("Kết quả console: " + Arrays.toString(output));
    }
}