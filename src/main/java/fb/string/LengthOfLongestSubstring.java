package fb.string;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() == 0 ) {
            return 0;
        }
        if(s.length()==1) {
            return 1;
        }

        char[] chars = s.toCharArray();

        Set<Character> set = new HashSet<>();
        int left = 0;
        int right =0;
        int max =0;
        while(right<chars.length) {
            if(!set.contains(chars[right])){
                max = Math.max(right-left+1,max);
                set.add(chars[right]);
                right++;
            }
            else{
                set.remove(chars[left]);
                left++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcdefaha"));
    }
}
