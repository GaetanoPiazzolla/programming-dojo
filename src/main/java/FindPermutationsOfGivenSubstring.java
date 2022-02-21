import java.util.ArrayList;
import java.util.Arrays;

public class FindPermutationsOfGivenSubstring {


    /**
     * Given 2 strings print the index of the permutations of the first string inside the second.
     */
    public static void printPermutations(String first, String second) {

        for (int i = 0; i < second.length(); i++) {
            String mayBePerm = second.substring(i, first.length());

            if (isPermutationMine(first, mayBePerm)) {
                System.out.println(i);
            }

        }

    }

    private static boolean isPermutationMine(String first, String second) {

        ArrayList<Character> chars = new ArrayList<>();
        for (char c : first.toCharArray()) {
            chars.add(c);
        }

        ArrayList<Character> chars2 = new ArrayList<>();
        for (char c : second.toCharArray()) {
            chars2.add(c);
        }

        for (Character aChar : chars) {
            if (!chars2.remove(aChar)) {
                return false;
            }
        }

        return chars2.size() == 0;
    }

    private static boolean isPermutationCountChar(String first, String second) {

        if (first.length() != second.length()) {
            return false;
        }

        char[] firstC = first.toCharArray();
        char[] secondC = second.toCharArray();

        // it is assumed that the characters are stored using 8 bit and there can be 256 possible characters.
        int[] letters = new int[256];
        Arrays.fill(letters, 0);

        for (int i = 0; i < firstC.length; i++) {
            letters[firstC[i]]++;
            letters[secondC[i]]--;
        }

        for (int i = 0; i < firstC.length; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean isPermutationSort(String first, String second) {

        if (first.length() != second.length()) {
            return false;
        }

        char[] firstC = first.toCharArray();
        char[] secondC = second.toCharArray();

        Arrays.sort(firstC);
        Arrays.sort(secondC);

        for (int i = 0; i < firstC.length; i++) {
            if (firstC[i] != secondC[i]) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {

        assert (isPermutationCountChar("abab", "aabb"));
        assert (!isPermutationCountChar("abadb", "aabb"));
        assert (isPermutationCountChar("abadb", "aadbb"));

        assert (isPermutationCountChar("abab", "aabb"));
        assert (!isPermutationCountChar("abadb", "aabb"));
        assert (isPermutationCountChar("abadb", "aadbb"));

        assert (isPermutationSort("abab", "aabb"));
        assert (!isPermutationSort("abadb", "aabb"));
        assert (isPermutationSort("abadb", "aadbb"));

        assert (isPermutationMine("abab", "aabb"));
        assert (!isPermutationMine("abadb", "aabb"));
        assert (isPermutationMine("abadb", "aadbb"));

    }

}
