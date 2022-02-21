package my_interviews.solutions;

public class AlgoUltimoProgetto {

    public static int ultimoProgetto(int n, int m, int s) {

        int pos = s;

        if (m > n) {
            m = m % n;
        }

        while (m > 1) {
            m--;
            pos++;
            if (pos > n) {
                pos = 1;
            }
        }

        return pos;
    }


    public static void main(String[] args) {

        // 1 2 3 4 5 consulenti ------ 3 progetti ----- parto 4 ->  1
        System.out.println("expected: 1 - result:" + ultimoProgetto(5, 3, 4));

        // 1 2 3 consulenti ---------- 4 progetti ----- parto 2 ->  2
        System.out.println("expected: 2 - result:" + ultimoProgetto(3, 4, 2));

        // 100 consulenti ---- 100 progetti ---- parto da 1 -> 100
        System.out.println("expected: 100 - result:" + ultimoProgetto(100, 100, 1));

        // 100 consulenti ---- 101 progetti ---- parto da 1 -> 1
        System.out.println("expected: 1 - result:" + ultimoProgetto(100, 101, 1));

    }
}
