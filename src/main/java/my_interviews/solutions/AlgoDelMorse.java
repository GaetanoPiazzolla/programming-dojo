package my_interviews.solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class AlgoDelMorse {

    public static void main(String[] args) {

        AlgoDelMorse m = new AlgoDelMorse();
        System.out.println(m.uniqueMorseRepresentations2(new String[]{"gin", "zen", "gig", "msg"}));

    }

    public int uniqueMorseRepresentations(String[] words) {

        String[] MORSE = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.",
                "---", ".--.", "--.-", ".-.", "...", "-", "..-",
                "...-", ".--", "-..-", "-.--", "--.."};

        Set<String> solutions = new HashSet();

        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
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

        Set<String> solutions = new HashSet<>();

        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(morse.get(word.charAt(i)));
            }
            solutions.add(sb.toString());
        }

        return solutions.size();
    }

}
