package problems;

public class AlgoDellaScalaRicorsiva {

    /**
     * Ho una scala costituita da N gradini.
     * Supponendo che posso salire 1 oppure 2 gradini alla volta
     * Costruire una funzione che calcola in quante maniere posso salire la scala.
     * <p>
     *
     * Ad esempio, se ho 3 gradini posso salire facendo
     * 1° gradino, 2° gradino, 3° gradino ( tre passi da 1)
     * 1° gradino, 3° gradino ( un passo da 1 e uno da 2)
     * 2° gradino, 3° gradino ( un passo da 2 e uno da 1)
     *
     * quindi la risposta è 3!
     */
    private static int n_ways(int n) {

       return 0;

    }

    public static void main(String[] args) {
        System.out.println("3-" + n_ways(3));
        System.out.println("5-" + n_ways(4));
    }

}
