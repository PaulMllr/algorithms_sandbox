package mergesort;

import java.util.Arrays;

import static java.lang.Math.min;

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

    /**
     *
     * @param array original array
     * @param copyArray result array
     * @param startIndex index of the beginning of the 1st merging part
     * @param endIndex index of the end of the 2nd merging part
     */
    public static void merge(Comparable[] array, Comparable[] copyArray, int startIndex, int endIndex) {

        // If there is nothing to merge - return
        if (startIndex == endIndex) {
            return;
        }
        // Calculating the border berween 2 parts
        int middle = startIndex + 1 + (endIndex - startIndex) / 2;

        int currentLeft = startIndex;
        int currentRight = middle;

        int leftLimit = middle;
        int rightLimit = endIndex + 1;


        // Iterating only through nodes we need to merge
        for (int i = startIndex; i <= endIndex; i++) {

            // If the 2nd part is exhausted, or array is out of bounds
            if (currentRight >= rightLimit || currentRight > array.length - 1) {
                copyArray[i] = array[currentLeft++];
                continue;
            }
            // If the 1st part is exhaused, or the 1st part is greater the 2nd part
            if (currentLeft >= leftLimit || array[currentLeft].compareTo(array[currentRight]) > 0) {
                copyArray[i] = array[currentRight++];
            } else {
                copyArray[i] = array[currentLeft++];
            }
        }
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

    public static Comparable[] bottomUpMergeSort(Comparable[] source) {

        // Copy data to the result array in advance
        Comparable[] result = Arrays.copyOf(source, source.length);

        // Merge part size. Starting from the bottom - 1. Then 2, 4, 8, etc
        int partSize = 1;

        while (partSize <= source.length / 2) {
            for (int i = 0; i < source.length; i = i + 2 * partSize) {
                int p1start = i;
                int p2start = i + partSize;
                // The array may end earlier than the part 2, so we need to choose min
                int p2end = min(p2start + partSize - 1, source.length - 1);
                // Merge consequently 2 parts
                merge(source, result, p1start, p2end);
            }
            partSize += partSize;
            // Before processing with the doule part size, we need to copy result array data to the source array
            source = Arrays.copyOf(result, result.length);

        }
        return result;
    }


}
