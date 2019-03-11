import java.util.*;

/**
 * Created by Pavel Laktiushkin on 11.03.2019
 */
public class VowelsReplace {


    public static void main(String[] args) {

        Character[] string = new Character[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'o', 'y', 'u'};
        System.out.println("Source array: " + Arrays.toString(string));
        replaceVowels(string);
        System.out.println("Result array: " + Arrays.toString(string));
    }


    public static void replaceVowels(Character[] source) {

        // First of all, we need a data structure for fast seeking vowels
        HashSet<Character> vowelsDictionary = getVowelsDictionary();

        // Next, we need to filter vowels from the source array
        List<Integer> vowels = new ArrayList<>();
        for (int i = 0; i < source.length; i++) {
            if (vowelsDictionary.contains(source[i])) {
                vowels.add(i);
            }
        }

        System.out.println("Vowels index array : " + vowels.toString());

        // Last, we need to invert vowel indexes in the src array
        for (int i = 0; i < vowels.size() / 2; i++) {
            Character tmp = source[vowels.get(i)];
            source[vowels.get(i)] = source[vowels.get(vowels.size() - 1 - i)];
            source[vowels.get(vowels.size() - 1 - i)] = tmp;
        }
    }

    private static HashSet<Character> getVowelsDictionary() {
        // Should contain all vowels buy we need only what we have in the source array
        return new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'y', 'u'));
    }

}
