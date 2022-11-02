package easy;

public class PalindromeNumber {

    public static void main(String[] args) {
        assert PalindromeNumber.isPalindrome(0);
        assert !PalindromeNumber.isPalindrome(100);
        assert PalindromeNumber.isPalindrome(101);
        assert !PalindromeNumber.isPalindrome(-1);
        assert PalindromeNumber.isPalindrome(1234554321);
    }

    public static boolean isPalindrome(int x) {

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
