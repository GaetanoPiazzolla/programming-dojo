package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class AlgoDelMorse {


    static HashMap<Character, String> dizionario = new HashMap<>();

    {

    }

    /**
     * Supponendo di avere una LISTA di PAROLE, trovare
     * quante conversioni in codice dizionario univoche posso fare.
     */
    private static int conversioniUnivocheIndizionario(String[] words) {

        dizionario.put('a', ".-");
        dizionario.put('b', "-...");
        dizionario.put('c', "-.-");
        dizionario.put('d', "-..");
        dizionario.put('e', ".");
        dizionario.put('f', "..-.");
        dizionario.put('g', "--.");
        dizionario.put('h', "....");
        dizionario.put('i', "..");
        dizionario.put('j', ".---");
        dizionario.put('k', "-.");
        dizionario.put('l', ".-..");
        dizionario.put('m', "--");
        dizionario.put('n', "-.");
        dizionario.put('o', "---");
        dizionario.put('p', ".--.");
        dizionario.put('q', "--.-");
        dizionario.put('r', ".-.");
        dizionario.put('s', "...");
        dizionario.put('t', "-");
        dizionario.put('u', "..-");
        dizionario.put('v', "...-");
        dizionario.put('w', ".--");
        dizionario.put('x', "-..-");
        dizionario.put('y', "-.--");
        dizionario.put('z', "--..");

        // prendo lower case
        String[] words2 = new String[words.length];
        for (int l = 0; l < words.length; l++) {
            words2[l] = words[l].toLowerCase(Locale.ROOT);
        }

        ArrayList<String> solutions = new ArrayList<>();

        for (int i = 0; i < words2.length; i++) {
            String convertita = converti(words2[i]);
            if(!solutions.contains(convertita)) {
                solutions.add(convertita);
            }
        }

        return solutions.size();
    }

    private static String converti(String s) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            output.append(dizionario.get(s.charAt(i)));
        }

        return output.toString();

    }

    public static void main(String[] args) {

        // --...-.     --...-.   --...--.   --...--.
        System.out.println("2-" + conversioniUnivocheIndizionario(new String[]{"gin", "zen", "gig", "msg"}));

        System.out.println("1-" + conversioniUnivocheIndizionario(new String[]{"rwjje", "aittjje", "auyyn", "lqtktn", "lmjwn"}));

    }


}
