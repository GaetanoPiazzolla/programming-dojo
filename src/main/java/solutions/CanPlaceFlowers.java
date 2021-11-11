package solutions;

public class CanPlaceFlowers {

    /**
     * You have a long prato in which some of the plots are planted, and some are not.
     * However, flowers cannot be planted in adjacent plots.
     * <p>
     * Given an integer array prato containing 0's and 1's, where 0 means empty and 1means not empty,
     * and an integer n, return if n new flowers can be planted in the prato
     * without violating the no-adjacent-flowers rule.
     */
    public static boolean canPlaceFlowers(int[] prato, int n) {

        if (n == 0) {
            return true;
        }

        if (prato == null || prato.length == 0) {
            return false;
        }

        for (int i = 0; i < prato.length ; i++) {

            if(prato[i] == 0 && (
                    i == prato.length -1 || prato[i+1] == 0))
            {
                n--;
                i++;
            }

            else if(prato[i]==1){
                i++;
            }

            if(n==0){
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

        assert (canPlaceFlowers(new int[]{1,0,0,0,0}, 1) == true);

        assert (canPlaceFlowers(new int[]{1,0}, 1) == false);

        assert (canPlaceFlowers(new int[]{1,0,1,0,1,0,0,1,0}, 1) == false);
        assert (canPlaceFlowers(new int[]{1,0,1,0,1,0,0,0}, 1) == true);


    }
}
