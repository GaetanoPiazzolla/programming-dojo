package my_interviews;

public class AlgoUltimoProgetto {

    /**
     * DXC ha N sviluppatori ed M progetti.
     * <p>
     * Gli sviluppatori sono seduti intorno ad un tavolo.
     * <p>
     * Bisogna assegnare ad ogni sviluppatore un progetto alla volta, fin quando non sono terminati, partendo dallo sviluppatore S.
     * <p>
     * Iniziando con lo sviluppatore S, determinare chi riceve l'ultimo progetto.
     */
    public static int ultimoProgetto(int n, int m, int s) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("expected: 1 - result:" + ultimoProgetto(5, 3, 4));
        System.out.println("expected: 2 - result:" + ultimoProgetto(3, 4, 2));
        System.out.println("expected: 100 - result:" + ultimoProgetto(100, 100, 1));
        System.out.println("expected: 1 - result:" + ultimoProgetto(100, 101, 1));
    }
}
