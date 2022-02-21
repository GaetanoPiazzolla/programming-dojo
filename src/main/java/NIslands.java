import java.util.HashMap;
import java.util.Map;

public class NIslands {

    public static int numIslands(char[][] grid) {
        Map<String, Integer> islandMap = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == '1') {

                    int numIsland = getIsland(i, j, islandMap);

                    if (j < grid[i].length - 1 && grid[i][j + 1] == '1') {
                        setIsland(i, j + 1, numIsland, islandMap);
                    }
                    if (i < grid.length - 1 && grid[i + 1][j] == '1') {
                        setIsland(i + 1, j, numIsland, islandMap);
                    }
                }
            }

        }

        return getMax(islandMap);

    }

    private static int getMax(Map<String, Integer> islandMap) {
        return islandMap.values().stream().max((entry1, entry2) -> entry1 > entry2 ? 1 : -1).orElse(0);
    }

    private static void setIsland(int i, int j, int numIsland, Map<String, Integer> islandMap) {
        islandMap.put(i + "-" + j, numIsland);
    }

    private static int getIsland(int i, int j, Map<String, Integer> islandMap) {
        if (islandMap.containsKey(i + "-" + j)) {
            return islandMap.get(i + "-" + j);
        } else {
            int v = getMax(islandMap);
            islandMap.put(i + "-" + j, ++v);
            return v;
        }
    }


    public static void main(String[] args) {

        char[][] grid =
                {
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}
                };

        System.out.println("1 - " + NIslands.numIslands(grid));

        grid =
                new char[][]{
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}
                };
        System.out.println("2 - " + NIslands.numIslands(grid));

        grid =
                new char[][]{
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}};
        System.out.println("3 - " + NIslands.numIslands(grid));

        grid = new char[][]{
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'},
        };
        System.out.println("1 - " + NIslands.numIslands(grid));
    }
}
