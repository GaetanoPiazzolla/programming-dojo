package alten;

public class ConsulentiCartelle {

    /**
     * Alten Italia ha un certo numero di consulenti e un certo numero di progetti da assegnare loro.
     * Il loro manager decide che il modo più equo per dividere i progetti è far sedere i consulenti attorno a un tavolo circolare su sedie numerate in sequenza.
     * Un numero di sedia verrà estratto da un cappello.
     * Iniziando con il consulente seduto su quella sedia, una cartella contenente un progetto verrà assegnata a ciascun consulente in sequenza attorno al tavolo fino a quando non saranno state distribuite tutte.
     * Il manager però ha in mente un piccolo scherzo.
     * L'ultima cartella appare simile a tutte le precedenti, ma in realtà è vuota.
     * Determina il numero della sedia occupata dal consulente che riceverà quella cartella.
     * <p>
     * <p>
     * n -> numero di consulenti
     * m -> numero di cartelle
     * s -> numero iniziale sedia
     */

    public static int sediaUltimaCartella(int n, int m, int s) {

        int pos = s;

        if( m > n ){
            m = m % n;
        }

        while(m > 1) {
            m--;
            pos++;
            if (pos > n) {
                pos = 1;
            }
        }

        return pos;
    }


    public static void main(String[] args) {

        // 1 2 3 4 5 consulenti ------ 3 cartelle ----- parto 4 ->  1
        System.out.println("expected: 1 - result:" + sediaUltimaCartella(5, 3, 4));

        // 1 2 3 consulenti ---------- 4 cartelle ----- parto 2 ->  2
        System.out.println("expected: 2 - result:" + sediaUltimaCartella(3, 4, 2));

        // 100 consulenti ---- 100 cartelle ---- parto da 1 -> 100
        System.out.println("expected: 100 - result:" + sediaUltimaCartella(100, 100, 1));

        // 100 consulenti ---- 101 cartelle ---- parto da 1 -> 1
        System.out.println("expected: 1 - result:" + sediaUltimaCartella(100, 101, 1));

    }
}
