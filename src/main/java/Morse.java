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

    public static void main(String[] args) {

        Morse m = new Morse();
        System.out.println(m.uniqueMorseRepresentations(new String[]{"gin","zen","gig","msg"}));

    }

}
