import mergesort.MergeSort;

import java.util.Arrays;
import java.util.Random;

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


        // Part 2. Checking the merge sort algorithm end-to-end
        Comparable[] unsortedArray = {'c', 'a', 'g', 'd', 'b', 'h', 'p', 'a', 'x'};
        System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));
        System.out.println("Sorted array: " + Arrays.toString(MergeSort.sort(unsortedArray)));

        // Part 2.5. Checking the bottom up merge sort end-to-end
        System.out.println("Bottom up sorted array: " + Arrays.toString(MergeSort.bottomUpMergeSort(unsortedArray)));


        // Part 3. Performance testing
        System.out.println("Performance test:");
        Comparable[] hugeUnsortedArray = new Comparable[10000000];
        Random random = new Random();
        for (int i = 0; i < hugeUnsortedArray.length; i++) {
            hugeUnsortedArray[i] = random.nextInt();
        }

        // Profiling recursive merge-sort
        long before = System.currentTimeMillis();
        MergeSort.sort(hugeUnsortedArray);
        long after = System.currentTimeMillis();
        System.out.printf("Merge sort for array[%d] took %dms%n", hugeUnsortedArray.length, after - before);

        // Profiling Bottom-Up merge-sort
        before = System.currentTimeMillis();
        MergeSort.bottomUpMergeSort(hugeUnsortedArray);
        after = System.currentTimeMillis();
        System.out.printf("Bottom-Up merge sort for array[%d] took %dms%n", hugeUnsortedArray.length, after - before);


    }
}
