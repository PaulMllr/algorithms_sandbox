import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pavel Laktiushkin on 11.03.2019
 */
public class VarietyOfCandies {


    // Given an array of candies, every candy can be of type [1...1000000].
    // The number of candies is even.
    // We need to give away a half of candies and preserve a half with the most possible variety.
    // The task is to write a function which returns the highest number of different types of candies we can preserve.


    public static void main(String[] args) {

        int[] src = new int[]{1, 2, 2, 2, 2, 3};
        System.out.println("Source array: " + Arrays.toString(src));

        System.out.println("Result is : " + getHighestNumberOfCandiesTypes(src));

    }

    public static int getHighestNumberOfCandiesTypes(int[] source) {

        Set<Integer> types = new HashSet<>();

        for (int candyType : source) {
            types.add(candyType);
        }

        System.out.println("Types set: " + types);

        return Math.min(types.size(), source.length / 2);
    }


}
