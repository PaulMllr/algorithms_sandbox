import java.util.ArrayList;
import java.util.List;


/*
 *  There is an alphabetic mapping: a->1 b->2 ... z->26
 *  The task is find how many ways there are to code an input string using the mapping.
 *  E.g. Input "123" can be coded in 3 ways: a+b+c, a+w, l+c
 *
 */
public class CodingCombinationsNumber {

    private String[] mapping = {"", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
            "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> result = new ArrayList<>();


    public int numberOfWays(String row) {
        decode("", row);
        System.out.println("Combinations:");
        result.forEach(System.out::println);
        return result.size();
    }

    private void decode(String decoded, String row) {
        if (row.isEmpty()) {
            result.add(decoded);
            return;
        }

        decode(decoded + mapping[Integer.valueOf(row.substring(0, 1))], row.substring(1));

        if (row.length() > 1 && Integer.valueOf(row.substring(0, 2)) < 27) {
            decode(decoded + mapping[Integer.valueOf(row.substring(0, 2))], row.substring(2));
        }
    }

    public static void main(String[] args) {
        CodingCombinationsNumber counter = new CodingCombinationsNumber();
        int result = counter.numberOfWays("123");
        System.out.printf("Number of ways: %d%n", result);
    }
}
