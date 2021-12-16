import java.util.LinkedHashMap;
import java.util.Map;

public class FindFirstNotRepeatingChar {

    /**
     * Find the first non repeating character. EPAM :)
     */
    public static Character nonRepeating(String input) {

        if (input == null || input.length() == 0) {
            return null;
        }

        Map<Character, Integer> nonRepeatingHash = new LinkedHashMap<>();

        for (int i = 0; i < input.length(); i++) {
            Integer a = nonRepeatingHash.get(input.charAt(i));
            if (a == null) {
                nonRepeatingHash.put(input.charAt(i), 1);
            } else {
                nonRepeatingHash.put(input.charAt(i), ++a);
            }
        }

        for (Map.Entry<Character, Integer> entry : nonRepeatingHash.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return null;
    }

    public static void main(String[] args) {

        System.out.println("abbbccdefga - non repeating is: " + FindFirstNotRepeatingChar.nonRepeating("abbbccdefga"));

    }

}
