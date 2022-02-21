public class StringDecodeMain {


    public static void main(String[] args) {

        StringDecodeMain c = new StringDecodeMain();
        System.out.println(c.decodeString("2[abc]3[cd]ef"));
        System.out.println(c.decodeString("a2[bc3[d]]"));
        System.out.println(c.decodeString("100[leetcode]"));
    }

    /**
     * Input: s = "2[abc]3[cd]ef"
     * Output: "abcabccdcdcdef"
     * <p>
     * Input: s = "3[a2[c]]"
     * Output: "accaccacc"
     */
    public String decodeString(String s) {

        return decodeRecursive(s);

    }

    private String decodeRecursive(String str) {

        StringBuilder toReturn = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {

            boolean foundNumber = false;

            StringBuilder numberBuilder = new StringBuilder();

            while (isNumber(str.charAt(i))) {
                foundNumber = true;
                numberBuilder.append(str.charAt(i));
                i++;
            }

            if (foundNumber) {
                i--;

                int number = Integer.parseInt(numberBuilder.toString());
                int j = i;
                int parenthesis = 0;

                do {
                    j++;
                    if (str.charAt(j) == '[') {
                        parenthesis++;
                    }
                    if (str.charAt(j) == ']') {
                        parenthesis--;
                    }
                }
                while (parenthesis != 0);

                while (number > 0) {
                    toReturn.append(decodeRecursive(str.substring(i + 2, j)));
                    number--;
                }

                i = j;
            } else {
                toReturn.append(str.charAt(i));
            }
        }

        return toReturn.toString();

    }

    private boolean isNumber(char aChar) {
        return aChar == '0' || aChar == '1' || aChar == '2' || aChar == '3' ||
                aChar == '4' || aChar == '5' || aChar == '6' || aChar == '7' || aChar == '8' || aChar == '9';
    }

}
