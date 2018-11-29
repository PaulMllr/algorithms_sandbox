import mergesort.MergeSort;

import java.util.Arrays;

/**
 * Created by Pavel Laktiushkin on 28.11.2018
 */
public class MergeSortLauncher {
    public static void main(String[] args) {
        // Part 1. Checking the merging function
        // Source char arrays. Feel free to modify the arrays but note that the content must be sorted
        Comparable[] arrayA = {'a', 'c', 'd', 'z'};
        Comparable[] arrayB = {'b', 'b', 'e', 's', 'y'};

        // Printing source arrays
        System.out.println("ArrayA: " + Arrays.toString(arrayA));
        System.out.println("ArrayB: " + Arrays.toString(arrayB));

        // Merging the two source array and printing the result sorted array
        Comparable[] result = MergeSort.merge(arrayA, arrayB);
        System.out.println("Result: " + Arrays.toString(result));


        // Part 2. Checking the mergesort algorithm end-to-end
        Comparable[] unsortedArray = {'j', 'c', 'a', 'z', 'b', 'h', 'p', 'a','x'};
        System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));
        System.out.println("Sorted array: " + Arrays.toString(MergeSort.sort(unsortedArray)));

    }
}
