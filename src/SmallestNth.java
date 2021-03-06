import java.util.Arrays;

/**
 * Created by Pavel Laktiushkin on 26.02.2019
 */


/**
 * A QuickSelect implementation to find the Nth smallest number in an unsorted array.
 * <p>
 * Time complexity:
 * average & best: O(n)
 * worst: O(n2)
 */
public class SmallestNth {

    public static void main(String[] args) {

        int hash = 7;
        int size = 4;


        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 150; j+=1) {
                int h1 = j % (i+1);
                int h2 = (i - 1) & j;
                System.out.println(h1 + " - " + h2);
            }
        }


    }

    public static int getNthMin(int[] arr, int m) {
        int pivotIndex = 0;
        int end = arr.length - 1;
        int comparingIndex = 0;
        int[] newArray = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[comparingIndex]) {
                // Move a number less to the beginning of the array
                newArray[pivotIndex++] = arr[i];
            } else {
                // Move a number bigger to the end of the array
                newArray[end--] = arr[i];
            }
        }
        // Put the last not-moved element to it's correct position
        newArray[pivotIndex] = arr[comparingIndex];

        System.out.printf("%s Pivot point: %d and Mth = %d%n", Arrays.toString(newArray), pivotIndex, m);

        if (m > pivotIndex) {
            // We need to check on the right side of the pivot
            return getNthMin(Arrays.copyOfRange(newArray, pivotIndex + 1, newArray.length), m - pivotIndex - 1);
        } else if (m < pivotIndex) {
            // We need to check on the left side of the pivot
            return getNthMin(Arrays.copyOfRange(newArray, 0, pivotIndex), m);
        } else {
            // We found the Mth smallest element. It is the Mth since we partially sorted the array -
            // we put everything less than the element to the left, and everything bigger to the right.
            // As a result, this Mth is in the right place as it would be a sorted array
            return newArray[pivotIndex];
        }


    }
}
