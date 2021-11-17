package interview.solutions;

public class AlgoDellAzzeramento {

    public static int solution(String S) {

        int operations = 0;

        while (S.startsWith("0"))
            S = S.substring(1);

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '1') {
                operations++;
            }
        }

        if (operations > 0) {
            operations--;
        }

        return operations + S.length();

    }

    public static int soluzioneBruteForce(String S) {

        int operations = 0;

        int number = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt( S.length() - i - 1 ) == '1') {
                number += potenza(2, i);
            }
        }

        while (number != 0) {

            if (number % 2 == 0) {
                number = number / 2;
            } else {
                number = number - 1;
            }

            operations++;
        }

        return operations;

    }

    private static int potenza(int base, int esponente) {
        int risultato = base;

        if (esponente == 0) {
            return 1;
        }

        for (int i = 0; i < esponente - 1; i++) {
            risultato = risultato * base;
        }

        return risultato;
    }


    /**
     * For a given string return the number of operation we need to do to reduce the string to 0
     * an operation can be a division by 2 or a -1.
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(solution("011100"));

    }
}
