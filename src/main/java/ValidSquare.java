import java.util.HashSet;
import java.util.Set;

/**
 * Given the coordinates of four points in 2D space, return whether the four points could construct a square.
 * <p>
 * The coordinate (x,y) of a point is represented by an integer array with two integers.
 * <p>
 * Example:
 * <p>
 * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * Output: True
 * <p>
 * <p>
 * Note:
 * <p>
 * All the input integers are in the range [-10000, 10000].
 * A valid square has four equal sides with positive length and four equal angles (90-degree angles).
 * Input points have no order.
 */
public class ValidSquare {

    // Y
    // ^      x       x    x
    // |   x     x
    // |      x       x    x
    // | ________ > X

    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        Set<Integer> set = new HashSet<>();

        try {
            set.add(spacialDistance(p1, p2));
            set.add(spacialDistance(p1, p3));
            set.add(spacialDistance(p1, p4));
            set.add(spacialDistance(p3, p2));
            set.add(spacialDistance(p3, p4));
            set.add(spacialDistance(p4, p2));
        }
        catch(NullPointerException e)
        {
            return false;
        }

        return set.size() == 2;
    }

    private static int spacialDistance(int[] p1, int[] p2) {
        int l1 = p1[0] - p2[0];
        int l2 = p1[1] - p2[1];

        if (l1 == 0 && l2 == 0) {
            throw new NullPointerException();
        }

        return l1 * l1 + l2 * l2;
    }

    public static void main(String[] arg) {

        System.out.println("True : " + validSquare(new int[]{0, 0}, new int[]{0, 1}, new int[]{1, 0}, new int[]{1, 1}));

        System.out.println("True : " + validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 1}));

        System.out.println("True : " + validSquare(new int[]{1, 3}, new int[]{2, 4}, new int[]{3, 3}, new int[]{2, 2}));

        System.out.println("False : " + validSquare(new int[]{1, 1},
                new int[]{5, 3},
                new int[]{3, 5},
                new int[]{7, 7}));
    }

}
