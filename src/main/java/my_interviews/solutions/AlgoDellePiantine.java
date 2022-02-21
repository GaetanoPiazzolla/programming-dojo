package my_interviews.solutions;

public class AlgoDellePiantine {

    public static boolean canPlaceFlowers(int[] prato, int n) {

        if (n == 0) {
            return true;
        }

        if (prato == null || prato.length == 0) {
            return false;
        }

        for (int i = 0; i < prato.length; i++) {

            if (prato[i] == 0 && (
                    i == prato.length - 1 || prato[i + 1] == 0)) {
                n--;
                i++;
            } else if (prato[i] == 1) {
                i++;
            }

            if (n == 0) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        assert (canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2) == false);
        assert (canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1) == true);
        assert (canPlaceFlowers(new int[]{0}, 1) == true);
        assert (canPlaceFlowers(new int[]{1}, 0) == true);
        assert (canPlaceFlowers(new int[]{1}, 1) == false);
        assert (canPlaceFlowers(new int[]{1, 0, 0, 0, 0}, 1) == true);
        assert (canPlaceFlowers(new int[]{1, 0}, 1) == false);
        assert (canPlaceFlowers(new int[]{1, 0, 1, 0, 1, 0, 0, 1, 0}, 1) == false);
        assert (canPlaceFlowers(new int[]{1, 0, 1, 0, 1, 0, 0, 0}, 1) == true);
    }
}
