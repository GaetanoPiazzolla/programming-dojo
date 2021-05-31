public class MaxPrefix {

    public String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length ==0 ){
            return "";
        }

        if(strs[0] == null || strs[0].length() == 0){
            return "";
        }

        if(strs.length == 1){
            return strs[0];
        }

        int j;
        for (j = 0; j < strs[0].length(); j++) {

            char a = strs[0].charAt(j);

            for (String str : strs) {
                if(str == null || str.length() == 0){
                    return "";
                }
                if (j >= str.length() || a != str.charAt(j)) {
                    return strs[0].substring(0, j);
                }
            }
        }

        if(j==strs[0].length())
        {
            return strs[0];
        }
        return "";

    }


    public static void main(String[] args) {

        MaxPrefix m = new MaxPrefix();
        //System.out.println(m.longestCommonPrefix(new String[]{"aaaaa", "aaaab", "aa"}));
        //System.out.println(m.longestCommonPrefix(new String[]{"dog", "dss", "dar"}));
        //System.out.println(m.longestCommonPrefix(new String[]{"dog", "aaa", "car"}));
        System.out.println(m.longestCommonPrefix(new String[]{"A"}));
        System.out.println(m.longestCommonPrefix(new String[]{"flower","flower","flower"}));

    }

}
