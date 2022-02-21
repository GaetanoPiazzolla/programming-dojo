import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII {

    public static void main(String[] args) {
        JumpGameIII j = new JumpGameIII();
        System.out.println("true: " + j.canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5));
        System.out.println("true: " + j.canReach(new int[]{0}, 0));
        System.out.println("false: " + j.canReach(new int[]{1}, 0));
        System.out.println("false: " + j.canReach(new int[]{3, 0, 2, 1, 2}, 2));
    }

    /**
     * Given an array of non-negative integers arr, you are initially positioned at start index of the array.
     * When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
     * <p>
     * Notice that you can not jump outside of the array at any time.
     */
    public boolean canReach(int[] arr, int start) {

        //return canReachRecursive(arr,start,0);

        return canReachQueue(arr, start);
    }

    private boolean canReachQueue(int[] arr, int start) {
        int n = arr.length;

        boolean[] seen = new boolean[n];

        Queue<Integer> bfs = new LinkedList<>();

        bfs.add(start);

        while (!bfs.isEmpty()) {
            int curr = bfs.poll();

            if (arr[curr] == 0)
                return true;

            if (seen[curr])
                continue;

            seen[curr] = true;

            int up = curr + arr[curr];
            if (up < n && !seen[up]) {
                bfs.add(up);
            }

            int down = curr - arr[curr];
            if (down >= 0 && !seen[down]) {
                bfs.add(down);
            }

        }
        return false;

    }

    // we need to count jumps to avoid loops :)
    private boolean canReachRecursive(int[] arr, int start, int jumps) {

        if (arr[start] == 0) {
            return true;
        }

        if (jumps > arr.length) {
            return false;
        }

        boolean canReach = false;

        if (arr.length > start + arr[start]) {
            canReach = canReachRecursive(arr, start + arr[start], ++jumps);
        }

        if (!canReach && start - arr[start] >= 0) {
            canReach = canReachRecursive(arr, start - arr[start], ++jumps);
        }

        return canReach;
    }

}
