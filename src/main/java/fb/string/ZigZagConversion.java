package fb.string;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if(numRows==1) {
            return s;
        }
        if(s.length() < numRows) {
            return s;
        }
        int passo = (numRows * 2) - 2;
        StringBuilder b = new StringBuilder();
        for(int i=0;i<numRows;i++)
        {
            int passo1 = passo - i*2;
            int passo2 = i*2;

            int j = i;
            b.append(s.charAt(j));
            while(j < s.length()) {

                if(passo1 > 0) {
                    j = j + passo1;
                    if(j<s.length()) {
                        b.append(s.charAt(j));
                    }
                }
                if(passo2 > 0) {
                    j = j + passo2;
                    if(j<s.length()) {
                        b.append(s.charAt(j));
                    }
                }

            }
        }

        return b.toString();


    }
}
