package mergesort;

import java.util.Arrays;

/**
 * Created by Pavel Laktiushkin on 28.11.2018
 */
public class MergeSort {

    /**
     * Merge function implementation
     *
     * @param arrayA first array. Must be sorted
     * @param arrayB second array. Must be sorted
     * @return result sorted array from merged operand arrays.
     */
    public static Comparable[] merge(Comparable[] arrayA, Comparable[] arrayB) {
        Comparable[] result = new Comparable[arrayA.length + arrayB.length];

        int i = 0, j = 0, k = 0;
        while (k < result.length) {

            // Check if the B array is exhausted
            if (j > arrayB.length - 1) {
                result[k++] = arrayA[i++];
                continue;
            }

            // Add the current ArrayB value to the result
            // if the array A is exhausted or the ArrayB current value is less than ArrayA.
            // Otherwise add the current ArrayA value.
            if (i > arrayA.length - 1 || arrayA[i].compareTo(arrayB[j]) > 0) {
                result[k++] = arrayB[j++];
            } else {
                result[k++] = arrayA[i++];
            }
        }

        return result;
    }

    public static Comparable[] sort(Comparable[] source) {
        // Recursion limit. There is nothing to sort in the array
        if (source.length < 2) {
            return source;
        }
        // Recursive sort the left half of the array
        Comparable[] left = sort(Arrays.copyOfRange(source, 0, source.length / 2));

        // Recursive sort the right half of the array
        Comparable[] right = sort(Arrays.copyOfRange(source, source.length / 2, source.length));

        // Return the merged sorted result
        return merge(left, right);
    }
}
