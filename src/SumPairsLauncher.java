import java.util.HashMap;

/**
 * Created by Pavel Laktiushkin on 02.03.2019
 */
public class SumPairsLauncher {


    public static void main(String... args) {


        System.out.println("Result is : " + countSumPairs(new int[]{1, 2, 4, 4, 6, 7, 8, 9, 12, 15}, 8));

    }


    /**
     * The method seeks and prints any pairs in the source array which sum equals to provided sum
     *
     * @param data source array of numbers
     * @param sum sum to be found
     * @return the number of pairs satisfy this condition
     */
    public static int countSumPairs(int[] data, int sum) {

        int result = 0;



        HashMap<Integer, Integer> hashtable = new HashMap<>(data.length);

        // O(n) solution - N times checking a hash table for required pair(Sum - data[i))
        // and putting current element into the hash table
        for (int i = 0; i < data.length; i++) {
            if (data[i] > sum) {
                break;
            }

            System.out.println("current is " + data[i] + "; now we need " + (sum - data[i]));
            // 2 find what we need in the hashtable
            Integer found = hashtable.get(sum - data[i]);
            if (null != found) {
                result++;
                System.out.println("[" + data[i] + " + " + data[found] + "]");
            }

            hashtable.put(data[i], i);


            // Optimized but still O(n2) solution
//            for (int j = i + 1; j < data.length; j++) {
//                int currentSum = data[i] + data[j];
//                if (currentSum == sum) {
//                    result++;
//                    System.out.println("[" + data[i] + " + " + data[j] + "]");
//                } else if (currentSum > sum) {
//                    break;
//                }
//            }
        }

        return result;


    }
}
