import java.util.HashMap;
import java.util.Map;

public class IntToRoman {


    public static String intToRoman(int n) {

        String number = Integer.toString(n);

        StringBuilder roman = new StringBuilder();

        for(int i = 0; i < number.length(); i++ ) {

            if(number.charAt(i)=='0') {
                continue;
            }

            // migliaia
            if(number.length() - i == 4) {
                int m = Character.getNumericValue(number.charAt(i));
                while(m>0) {
                    roman.append("M");
                    m--;
                }
            }

            // centinaia
            if(number.length() - i == 3) {
                int c = Character.getNumericValue(number.charAt(i));
                roman.append(IntToRoman.convertUnit(c, "CM", "CD", "D", "C"));
            }

            if(number.length() - i == 2) {
                int c = Character.getNumericValue(number.charAt(i));
                roman.append(IntToRoman.convertUnit(c, "XC", "XL", "L", "X"));
            }

            if(number.length() - i == 1) {
                int c = Character.getNumericValue(number.charAt(i));
                roman.append(IntToRoman.convertUnit(c, "IX", "IV", "V", "I"));
            }

        }

        return roman.toString();


    }

    public static String convertUnit(int c, String nine, String four, String five, String one) {
        StringBuilder roman = new StringBuilder();
        if(c==9) {
            roman.append(nine);
        }
        else if(c==4) {
            roman.append(four);
        }
        else {
            while(c>0) {
                if(c>=5) {
                    roman.append(five);
                    c=c-5;
                }
                if(c>=1) {
                    roman.append(one);
                    c=c-1;
                }
            }
        }
        return roman.toString();
    }


    public static void main(String[] args) {

        System.out.println("MMM - "+ IntToRoman.intToRoman(3000));
        System.out.println("MCM - "+ IntToRoman.intToRoman(1900));
        System.out.println("CM - "+ IntToRoman.intToRoman(900));
        System.out.println("DCCC - "+ IntToRoman.intToRoman(800));
        System.out.println("DCC - "+ IntToRoman.intToRoman(700));
        System.out.println("CD - "+ IntToRoman.intToRoman(400));
        System.out.println("LVIII- "+IntToRoman.intToRoman(58));
        System.out.println("MCMXCIV - "+IntToRoman.intToRoman(1994));



    }

}
