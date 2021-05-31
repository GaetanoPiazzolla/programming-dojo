import java.util.Arrays;

public class PalindromePermutation {

    /**
     * Given a String of characters, return true if it's a permutation of a palindrme.
     */
    public static boolean isPermutationOfPalindrome(String toCheck) {

        int[] array = new int[26];
        Arrays.fill(array, -1);

        for (int i = 0; i < toCheck.length(); i++) {
            int increment = array[toCheck.charAt(i) - 'a'];
            if (increment < 0) {
                ++increment;
            }
            ++increment;
            array[toCheck.charAt(i) - 'a'] = increment;
        }

        boolean oddFound = false;
        for (int i = 0; i < 26; i++) {
            if (array[i] > 0 && array[i] % 2 != 0) {
                if (oddFound) {
                    return false;
                }
                oddFound = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPermutationOfPalindrome("aabb"));
        System.out.println(isPermutationOfPalindrome("abab"));

        System.out.println(isPermutationOfPalindrome("ciaociao"));

        System.out.println(isPermutationOfPalindrome("adfjivadfjvoij"));

        System.out.println(isPermutationOfPalindrome("iiiiiiiiiiiu"));
        System.out.println(isPermutationOfPalindrome("iiiiiiiiiiiiu"));

        System.out.println(isPermutationOfPalindrome("z"));

    }
}