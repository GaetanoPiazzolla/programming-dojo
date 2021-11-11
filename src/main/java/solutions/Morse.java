package solutions;

import java.util.*;

public class Morse {


    public int uniqueMorseRepresentations(String[] words) {

        String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-",
                "...-",".--","-..-","-.--","--.."};

        Set<String> solutions = new HashSet();

        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<word.length();i++)
            {
                sb.append(MORSE[word.charAt(i) - 'a']);
            }
            solutions.add(sb.toString());
        }

        return solutions.size();

    }

    public int uniqueMorseRepresentations2(String[] words) {
        HashMap<Character, String> morse = new HashMap<>();
        morse.put('a', ".-");
        morse.put('b', "-...");
        morse.put('c', "-.-");
        morse.put('d', "-..");
        morse.put('e', ".");
        morse.put('f', "..-.");
        morse.put('g', "--.");
        morse.put('h', "....");
        morse.put('i', "..");
        morse.put('j', ".---");
        morse.put('k', "-.");
        morse.put('l', ".-..");
        morse.put('m', "--");
        morse.put('n', "-.");
        morse.put('o', "---");
        morse.put('p', ".--.");
        morse.put('q', "--.-");
        morse.put('r', ".-.");
        morse.put('s', "...");
        morse.put('t', "-");
        morse.put('u', "..-");
        morse.put('v', "...-");
        morse.put('w', ".--");
        morse.put('x', "-..-");
        morse.put('y', "-.--");
        morse.put('z', "--..");

        String[] soluzioni = new String[words.length];

        int j = 0;
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(morse.get(word.charAt(i)));
            }
            soluzioni[j] = sb.toString();
            j++;
        }

        Arrays.sort(soluzioni);

        return removeDuplicateElements(soluzioni, soluzioni.length);

    }

    public static int removeDuplicateElements(String[] arr, int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        String[] temp = new String[n];
        int j = 0;
        for (int i = 0; i < n - 1; i++) {
            if (!arr[i].equals(arr[i + 1])) {
                temp[j++] = arr[i];
            }
        }
        temp[j++] = arr[n - 1];
        // Changing original array
        for (int i = 0; i < j; i++) {
            arr[i] = temp[i];
        }
        return j;
    }


    public static void main(String[] args) {

        Morse m = new Morse();
        System.out.println(m.uniqueMorseRepresentations(new String[]{"gin","zen","gig","msg"}));

    }

}
