package my_interviews;

public class AlgoDellePiantine {

    /**
     * Abbiamo un prato (UNIDIMENSIONALE) in cui ci sono degli spazi per piantare alcune piantine.
     * Alcuni spazi sono occupati e altri invece no.
     * <p>
     * Se uno spazio e' occupato, gli spazi adiacenti a destra e a sinistra non possono essere occupati.
     * <p>
     * Avendo in input un ARRAY con 0 e 1, in cui 0 significa libero e 1 occupato
     * e un numero di piantine N,
     * capire se le N piantine possono essere inserite nel prato rispettando la regola di adiacenza.
     */
    public static boolean possoMetterePiantine(int[] flowerbed, int n) {
        return false;
    }

    public static void main(String[] args) {

        System.out.println("false-" + possoMetterePiantine(new int[]{1, 0, 0, 0, 1}, 2));
        System.out.println("false-" + possoMetterePiantine(new int[]{1}, 1));
        System.out.println("false-" + possoMetterePiantine(new int[]{1, 0}, 1));
        System.out.println("false-" + possoMetterePiantine(new int[]{1, 0, 1, 0, 1, 0, 0, 1, 0}, 1));
        System.out.println("true-" + possoMetterePiantine(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println("true-" + possoMetterePiantine(new int[]{0}, 1));
        System.out.println("true-" + possoMetterePiantine(new int[]{1}, 0));
        System.out.println("true-" + possoMetterePiantine(new int[]{1, 0, 0, 0, 0}, 1));
        System.out.println("true-" + possoMetterePiantine(new int[]{1, 0, 1, 0, 1, 0, 0, 0}, 1));
    }

}
