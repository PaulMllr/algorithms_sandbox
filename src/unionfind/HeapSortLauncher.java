package unionfind;

import heapsort.BinaryHeap;
import heapsort.HeapSort;

import java.util.Arrays;

/**
 * Created by Pavel Laktiushkin on 08.12.2018
 */
public class HeapSortLauncher {

    public static void main(String[] args) {

        // Part 1. Binary heap testing
        BinaryHeap binaryHeap = new BinaryHeap(100);
        binaryHeap.add("s");
        binaryHeap.add("o");
        binaryHeap.add("r");
        binaryHeap.add("t");
        binaryHeap.add("e");
        binaryHeap.add("x");
        binaryHeap.add("a");
        binaryHeap.add("m");
        binaryHeap.add("p");
        binaryHeap.add("l");
        binaryHeap.add("e");
        System.out.println("Result heap tree:        " + binaryHeap.showDataArrayHuman());
        System.out.println("Popped max = " + binaryHeap.popMax());
        System.out.println("After max Pop heap tree: " + binaryHeap.showDataArrayHuman());


        // Part 2. Heap sort testing
        Comparable[] sorted = HeapSort.sort('s', 'o', 'r', 't', 'e', 'x', 'a', 'm', 'p', 'l', 'e');
        System.out.println("Heap sorted result: " + Arrays.toString(sorted));

    }
}
