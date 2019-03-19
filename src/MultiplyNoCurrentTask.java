import java.util.Arrays;

/**
 * Created by Pavel Laktiushkin on 17.03.2019
 */
public class MultiplyNoCurrentTask {

    public static void main(String... args) {

        int[] src = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(src));
        int[] result = compute(src);

        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(computeNoDivision(src)));

    }


    public static int[] compute(int[] src) {

        int[] result = new int[src.length];
        int totalMultiply = 1;

        // O(n)
        for (int i = 0; i < src.length; i++) {
            totalMultiply = totalMultiply * src[i];
        }

        // O(n)
        for (int i = 0; i < src.length; i++) {
            if (src[i] != 0) {
                result[i] = totalMultiply / src[i];
            }
        }

        return result;
    }


    public static int[] computeNoDivision(int[] src) {

        int[] result = new int[src.length];
        int[] multiplyLeft = new int[src.length];
        int[] multiplyRight = new int[src.length];

        // O(n)
        for (int i = 0; i < src.length; i++) {
            if (i == 0) {
                multiplyLeft[i] = src[i];
                multiplyRight[src.length - i - 1] = src[src.length - i - 1];
            } else {
                multiplyLeft[i] = multiplyLeft[i - 1] * src[i];
                multiplyRight[src.length - i - 1] = multiplyRight[src.length - i] * src[src.length - i - 1];
            }
        }

        // O(n)
        for (int i = 0; i < src.length; i++) {
            if (i == 0) {
                result[i] = multiplyRight[1];
            } else if (i == src.length - 1) {
                result[i] = multiplyLeft[src.length - 2];
            } else {
                result[i] = multiplyLeft[i - 1] * multiplyRight[i + 1];
            }
        }


        return result;
    }


}
