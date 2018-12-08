package heapsort;

/**
 * Created by Pavel Laktiushkin on 08.12.2018
 */
public class HeapSort {

    public static Comparable[] sort(Comparable... keys) {
        // Part 1. Build a binary heap
        BinaryHeap binaryHeap = new BinaryHeap(keys.length + 1);
        // Usage of the bottom-up method to build a binary heap would be more optimal
        for (Comparable key : keys) {
            binaryHeap.add(key);
        }

        // Extract max values consequently to build a sorted array
        Comparable[] result = new Comparable[keys.length];
        // Start from the end of the result array since we pop the biggest value
        for (int i = keys.length - 1; i >= 0; i--) {
            result[i] = binaryHeap.popMax();
        }
        return result;
    }
}
