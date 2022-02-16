package crackingiw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationFrequencies {

    // o(n) complexity
    public static void main(String[] args) {

        String base = "abcabbccccababcababcab";
        String pattern = "abc";

        List<String> permutations = new ArrayList<>();

        Map<Character, Integer> frequencyMap = new HashMap<>();
        Map<Character, Integer> frequencyBase = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            Integer a = frequencyMap.get(pattern.charAt(i));
            if (a == null) {
                frequencyMap.put(pattern.charAt(i), 1);
                frequencyBase.put(base.charAt(i), 1);
            } else {
                frequencyMap.put(pattern.charAt(i), a + 1);
                frequencyBase.put(base.charAt(i), a + 1);
            }
        }

        if (frequencyMap.equals(frequencyBase)) {
            permutations.add(base.substring(0, pattern.length()));
        }

        for (int i = 1; i < base.length() - pattern.length() + 1; i++) {

            Integer f = frequencyBase.get(base.charAt(i - 1));
            if (f != null) {
                if (f == 1) {
                    frequencyBase.remove(base.charAt(i - 1));
                } else {
                    frequencyBase.put(base.charAt(i - 1), f - 1);
                }
            }

            char key = base.charAt(i + pattern.length() - 1);

            Integer a = frequencyBase.get(key);
            if (a == null) {
                frequencyBase.put(key, 1);
            } else {
                frequencyBase.put(key, a + 1);
            }

            if (frequencyMap.equals(frequencyBase)) {
                permutations.add(base.substring(i, i + pattern.length()));
            }
        }

        System.out.println(permutations);

    }
}
