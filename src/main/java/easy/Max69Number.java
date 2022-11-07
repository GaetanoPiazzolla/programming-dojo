package easy;

public class Max69Number {

    /**
     * You are given a positive integer num consisting only of digits 6 and 9.
     * Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
     *
     * 9969 -> 9999
     * 6666 -> 9666
     *
     * TODO This solution has o(n) time and o(n) space
     * what if we want to have O(1) space complexity - that means without using the char[] ?
     */
    public int maximum69Number(int num) {

        if(num < 6){
            return num;
        }

        char[] numChar =  String.valueOf(num).toCharArray();

        for(int i=0; i<numChar.length ; i++){
            if(numChar[i] == '6') {
                numChar[i] = '9';
                break;
            }
        }

        return Integer.parseInt(new String(numChar));

    }

}
