import java.util.HashMap;
import java.util.Map;

class IsAnagram {

    public boolean isAnagram(String s, String t) {

        //1 exit fast
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }

        //2 count frequencies in first string
        Map<Character, Integer> frequencies = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            Integer frequency = frequencies.getOrDefault(s.charAt(i), 0);
            frequencies.put(s.charAt(i), ++frequency);
        }

        //3 remove frequencies in second string
        for (int i = 0; i < t.length(); i++) {
            Integer frequency = frequencies.get(t.charAt(i));
            if (frequency == null || frequency <= 0) {
                return false;
            }
            frequencies.put(s.charAt(i), --frequency);
        }

        //4 false if occurrencies do not match
        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean betterIsAnagram(String s, String t) {
        if (s.length() != t.length()) return false; // supposing that s and t cannot be null
        int[] counter = new int[26]; // number of letter of english alphabet
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int i : counter) {
            if (i != 0) return false;
        }
        return true;
    }

}