import java.util.HashMap;
import java.util.Map;

public class RomanToInt {


    public static int romanToInt(String s) {

        Map<Character, Integer> dictionary = new HashMap<>();
        dictionary.put('I', 1);
        dictionary.put('V', 5);
        dictionary.put('X', 10);
        dictionary.put('L', 50);
        dictionary.put('C', 100);
        dictionary.put('D', 500);
        dictionary.put('M', 1000);

        Map<String, Integer> diff = new HashMap<>();
        diff.put("IV", 4);
        diff.put("IX", 9);
        diff.put("XL", 40);
        diff.put("XC", 90);
        diff.put("CD", 400);
        diff.put("CM", 900);

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && diff.get(s.substring(i, i + 2)) != null) {
                sum += diff.get(s.substring(i, i + 2));
                i++;
            } else {
                sum += dictionary.get(s.charAt(i));
            }
        }

        return sum;

    }


    public static void main(String[] args) {

        System.out.println("3-"+ RomanToInt.romanToInt("III"));
        System.out.println("4-"+ RomanToInt.romanToInt("IV"));
        System.out.println("9-"+ RomanToInt.romanToInt("IX"));
        System.out.println("58-"+ RomanToInt.romanToInt("LVIII"));
        System.out.println("1994-"+ RomanToInt.romanToInt("MCMXCIV"));

    }

}
