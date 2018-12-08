package heapsort;

import java.util.Arrays;

/**
 * Created by Pavel Laktiushkin on 08.12.2018
 */
public class BinaryHeap {

    private int N = 0;
    private Comparable[] data;

    public BinaryHeap(int maxCapacity) {
        // +1 because our root is located in the [1] rather than [0], for simpler calculations
        data = new Comparable[maxCapacity + 1];
    }

    public void add(Comparable key) {
        if (N > 1) {
            System.out.println("Adding '" + key + "' to " + showDataArrayHuman());
        }
        data[++N] = key;
        swim(N);
    }

    public Comparable popMax() {
        Comparable max = data[1];
        exchange(1, N);
        data[N--] = null;
        sink(1);
        return max;
    }


    private void swim(int n) {
        while (n > 1 && data[n].compareTo(data[n / 2]) > 0) {
            exchange(n, n / 2);
            n = n / 2;
            System.out.println("Data after swim: " + showDataArrayHuman());
        }
    }

    private void sink(int i) {
        while (2 * i <= N && data[i].compareTo(max(data[i * 2], data[i * 2 + 1])) < 0) {
            if (2 * i == N || data[i * 2].compareTo(max(data[i * 2], data[i * 2 + 1])) == 0) {
                exchange(i, i * 2);
                i += i;
            } else {
                exchange(i, i * 2 + 1);
                i += i + 1;
            }
            System.out.println("Data after sink: " + showDataArrayHuman());
        }
    }

    private void exchange(int i, int j) {
        Comparable buffer = data[i];
        data[i] = data[j];
        data[j] = buffer;
    }

    private Comparable max(Comparable v1, Comparable v2) {
        if (v1 == null) {
            return v2;
        } else if (v2 == null) {
            return v1;
        } else {
            return v1.compareTo(v2) >= 0 ? v1 : v2;
        }
    }

    public String showDataArrayHuman() {
        return Arrays.toString(Arrays.copyOfRange(data, 1, N + 1));
    }
}
