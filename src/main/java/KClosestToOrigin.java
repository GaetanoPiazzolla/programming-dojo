



import structures.Pair;

import java.util.PriorityQueue;
import java.util.Queue;


public class KClosestToOrigin {

    /**
     * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
     * return the k closest points to the origin (0, 0).
     * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
     * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
     */
    public int[][] kClosest(int[][] points, int k) {

        Queue<Pair<Double,int[]>> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.left < o2.left)
                return 1;
            return -1;
        });

        for (int[] point : points) {
            double distance = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
            queue.add(Pair.of(distance, point));
        }

        int[][] closest = new int[k][2];
        for(int i=0; i<k ; i++) {
            closest[i] = queue.poll().right;
        }

        return closest;
    }

}
