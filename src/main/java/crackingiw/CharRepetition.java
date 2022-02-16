package crackingiw;

import java.util.Random;

public class CharRepetition {

    // es 1.1
    public static void main(String[] args) {

        StringBuilder b = new StringBuilder();

        // a -> 97 decimal ascii value -> '\u0061' in unicode (61 is exadecimal for 97)
        System.out.println('a');
        System.out.println((int) 'a');
        System.out.println('\u0061');

        // z -> 122 decimal ascii value -> '\u007A' in unicode (7A is exadecimal for 122)
        System.out.println('z');
        System.out.println((int) 'z');
        System.out.println('\u007A');

        int lowerIndex = 97;
        int higherIndex = 122;
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            b.append((char) (random.nextInt(higherIndex - lowerIndex) + lowerIndex));
        }

        // if I try to append an unicode char this will break.
        // Index 537 out of bounds for length 25
        // b.append('\u027A');

        System.out.println("---------------------------");
        System.out.println("String \n-" + b + "\nIs unique?");
        System.out.println(allUniqueCharBruteForce(b.toString()));
        System.out.println(allUniqueCharOrderedString(b.toString()));
        System.out.println(allUniqueCharAdditionalArray(b.toString()));
    }

    // o(n) time and o(n) space
    private static boolean allUniqueCharAdditionalArray(String input) {
        // with the assumption of characters raging from 97 to 122 we can create the correct boolean array to check.
        boolean[] checkArray = new boolean[122 - 97];
        for (int i = 0; i < input.length(); i++) {
            int position = input.charAt(i) - 97;
            if (checkArray[position]) {
                return false;
            } else {
                checkArray[position] = true;
            }
        }
        return true;
    }

    // brute force, o(1) space o(n^2) time
    private static boolean allUniqueCharBruteForce(String input) {
        for (int i = 0; i < input.length() - 1; i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // O(n * logn) + o(n) time complexity
    private static boolean allUniqueCharOrderedString(String input) {
        String orderedString = newQuickSortedString(input);
        for (int i = 0; i < orderedString.length() - 1; i++) {
            if (orderedString.charAt(i) == orderedString.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private static String newQuickSortedString(String input) {
        char[] array = input.toCharArray();
        quickSort(array, 0, array.length - 1);
        return new String(array);
    }

    private static void quickSort(char[] array, int leftLimit, int rightLimit) {

        if (rightLimit <= leftLimit) {
            return;
        }

        char pivot = array[rightLimit];
        int leftPointer = leftLimit;
        int rightPointer = rightLimit;

        while (leftPointer < rightPointer) {
            while (pivot >= array[leftPointer] && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (pivot <= array[rightPointer] && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);
        }
        swap(array, leftPointer, rightLimit);

        quickSort(array, leftPointer + 1, rightLimit);
        quickSort(array, leftLimit, leftPointer - 1);

    }

    private static void swap(char[] array, int pos1, int pos2) {
        char tmp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = tmp;
    }

}
