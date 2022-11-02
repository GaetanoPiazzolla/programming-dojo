import java.util.HashMap;
import java.util.Map;

public class FindFirstNotRepeatingChar {

    /**
     * Find the first non repeating character. EPAM :)
     */
    public static Character nonRepeating(String input) {

        if (input == null || input.length() == 0) {
            return null;
        }

        Map<Character, Integer> nonRepeatingHash = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            Integer a = nonRepeatingHash.getOrDefault(input.charAt(i), 0);
            nonRepeatingHash.put(input.charAt(i), ++a);
        }

        for (int i = 0; i < input.length(); i++) {
            if(nonRepeatingHash.get(input.charAt(i))==1){
                return input.charAt(i);
            }
        }

        return null;
    }

    public static void main(String[] args) {

        System.out.println("abbbccdefga - non repeating is: " + FindFirstNotRepeatingChar.nonRepeating("abbbccdefga"));

    }

}
