public class Palindrome {


    public static String solution(String S) {

        if(S == null || S.isEmpty() ) {
            return "NO";
        }

        char[] anyPalidrome = new char[S.length()];

        boolean notEquals = false;

        char middle = S.charAt(S.length() / 2) == '?' ? 'a' : S.charAt(S.length() / 2);
        anyPalidrome[S.length() / 2] = middle;

        for(int i=0; i < S.length() / 2; i++) {

            Character equalChar = getEqualCharacter(S.charAt(i),S.charAt(S.length() -1 -i));
            if(equalChar!=null) {
                anyPalidrome[i]=equalChar;
                anyPalidrome[S.length()-1-i] = equalChar;
            }
            else {
                notEquals = true;
            }
        }

        if(!notEquals) {
            return new String(anyPalidrome);
        }

        return "NO";

    }

    private static Character getEqualCharacter(char first, char last) {

        if(first == '?' && last == '?') {
            return 'a';
        }

        else if(first == last) {
            return first;
        }

        else if (first == '?') {
            return last;
        }

        else if(last == '?') {
            return first;
        }

        else{
            return null;
        }

    }

    public static void main(String[] args) {

        String abc = "abc?cba";
        System.out.println(Palindrome.solution(abc));

        abc = "a?a";
        System.out.println(Palindrome.solution(abc));

        abc = "?a?";
        System.out.println(Palindrome.solution(abc));

        abc = "?";
        System.out.println(Palindrome.solution(abc));

         abc = "?ab??a";
        System.out.println(Palindrome.solution(abc));

        abc = "z";
        System.out.println(Palindrome.solution(abc));

    }
}
