package problems;

public class AlgoDellAzzeramento {

    /**
     * Avendo in input una stringa fatta da 0 e 1,
     * ritornare il numero di operazioni che necessitiamo per ridurre la stringa a 0
     * considerando che una operazione puo' essere o una divisione per due oppure una sottrazione di 1
     * <p>
     * Esempio:
     * <p>
     * 11 ( = 3 in decimale) -> 3 operazioni
     * 110 ( = 6 in decimale ) -> 4 operazioni
     * 111 ( = 7 in decimale ) -> 5 operazioni
     * 1010 ( = 10 in decimale) -> 10 / 2 -> 5 - 1 -> 4 / 2 -> 2 - 1 -> 1 - 1 -> 0  -> 5 operazioni
     */
    public static int solution(String S) {

        int operations = 0;

        while (S.length() > 1 && S.charAt(0) == '0') {
            S = S.substring(1);
        }

        while (!S.equals("0")) {
            if (S.charAt(S.length() - 1) == '0') {
                S = S.substring(0, S.length() - 1);
            } else {
                S = S.substring(0, S.length() - 1);
                S = S + '0';
            }
            operations++;
        }

        return operations;

    }


    public static void main(String[] args) {

        System.out.println("0-" + solution("0000"));
        System.out.println("0-" + solution("0"));
        System.out.println("1-" + solution("01"));
        System.out.println("1-" + solution("1"));

        System.out.println("3-" + solution("11"));
        System.out.println("4-" + solution("110"));
        System.out.println("5-" + solution("111"));
        System.out.println("5-" + solution("1010"));

        System.out.println("177-" + solution("11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"));

    }

}
