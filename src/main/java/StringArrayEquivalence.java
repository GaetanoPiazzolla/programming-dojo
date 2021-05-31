public class StringArrayEquivalence {

    /**
     * Given two string arrays word1 and word2,
     * return true if the two arrays represent the same string,
     * and false otherwise.
     * <p>
     * A string is represented by an array if the array elements concatenated in order forms the string.
     */
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        StringBuilder builder = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();

        int i = 0;
        for (; i < word1.length && i < word2.length; i++) {

            builder.append(word1[i]);
            builder2.append(word2[i]);

            String partial1 = builder.toString();
            String partial2 = builder2.toString();

            if (partial1.length() < partial2.length()) {
                if (!partial2.startsWith(partial1)) {
                    return false;
                }
            }
            else if(partial1.length() == partial2.length())
            {
                if(!partial1.equals(partial2))
                {
                    return false;
                }
            }
            else{
                if (!partial1.startsWith(partial2)) {
                    return false;
                }
            }
        }

        while (i < word1.length) {
            builder.append(word1[i]);
            i++;
        }

        while (i < word2.length) {
            builder2.append(word2[i]);
            i++;
        }

        return builder.toString().equals(builder2.toString());
    }

    public static void main(String[] args) {
//        System.out.println("true: "+ arrayStringsAreEqual(new String[]{"a","bc","d"},new String[]{"a","bcd"}));
//        System.out.println("false: "+ arrayStringsAreEqual(new String[]{"a","bc","d"},new String[]{"a","bc"}));
//        System.out.println("true: "+ arrayStringsAreEqual(new String[]{"a","","bcd"},new String[]{"a","bc","d"}));
        System.out.println("true: "+ arrayStringsAreEqual(new String[]{"fvnzyxfmvtsezl"},new String[]{"f","v","nzyx","fmvt","sez","l"}));
    }
}
