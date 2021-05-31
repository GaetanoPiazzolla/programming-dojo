public class CanPlaceFlowers {

    /**
     * You have a long flowerbed in which some of the plots are planted, and some are not.
     * However, flowers cannot be planted in adjacent plots.
     * <p>
     * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1means not empty,
     * and an integer n, return if n new flowers can be planted in the flowerbed
     * without violating the no-adjacent-flowers rule.
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (n == 0) {
            return true;
        }

        if (flowerbed == null || flowerbed.length == 0) {
            return false;
        }

        for (int i = 0; i < flowerbed.length ; i++) {

            if(flowerbed[i] == 0 && (
                    i == flowerbed.length -1 || flowerbed[i+1] == 0))
            {
                n--;
                i++;
            }

            else if(flowerbed[i]==1){
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
