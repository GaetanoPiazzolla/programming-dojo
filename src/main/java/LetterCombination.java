import java.util.*;

public class LetterCombination {

    /**
     * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
     * Return the answer in any order.
     * <p>
     * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
     * <p>
     * Input: digits = "23"
     * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * <p>
     * Input: digits = ""
     * Output: []
     * <p>
     * Input: digits = "2"
     * Output: ["a","b","c"]
     */
    public static List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        Map<Integer, String[]> map = new HashMap<>();
        map.put(2, new String[]{"a", "b", "c"});
        map.put(3, new String[]{"d", "e", "f"});
        map.put(4, new String[]{"g", "h", "i"});
        map.put(5, new String[]{"j", "k", "l"});
        map.put(6, new String[]{"m", "n", "o"});
        map.put(7, new String[]{"p", "q", "r", "s"});
        map.put(8, new String[]{"t", "u", "v"});
        map.put(9, new String[]{"w", "x", "y", "z"});

        for (int i = 0; i < digits.length(); i++) {

            Integer c = Character.getNumericValue(digits.charAt(i));
            String[] singleDigitValues = map.get(c);

            if (result.size() == 0) {
                result.addAll(Arrays.asList(singleDigitValues));
            } else {
                List<String> resultCopy = new ArrayList<>(result);
                for (String s : resultCopy) {
                    result.remove(s);
                    for (String singleDigitValue : singleDigitValues) {
                        result.add(s + singleDigitValue);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("abc - " + LetterCombination.letterCombinations("2"));
        System.out.println("ad ae af bc be bf cd ce cf " + LetterCombination.letterCombinations("23"));
    }

}