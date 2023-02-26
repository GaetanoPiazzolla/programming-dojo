package name;

import easy.PalindromeNumber;

public class NameThis {


    public static void main(String[] args) {
        assert NameThis.xxxx(0);
        assert !NameThis.xxxx(100);
        assert NameThis.xxxx(101);
        assert !NameThis.xxxx(-1);
        assert NameThis.xxxx(1234554321);
    }

    public static boolean xxxx(int x) {

        if(x < 0) {
            return false;
        }
        if(x < 10) {
            return true;
        }

        String y = String.valueOf(x);

        int half = y.length() / 2;

        for(int i=0; i < half; i++) {
            if(y.charAt(i) != y.charAt(y.length()-1-i)){
                return false;
            }
        }

        return true;
    }

}
