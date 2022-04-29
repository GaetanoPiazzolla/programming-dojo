package fb.dp;



import structures.Pair;

import java.util.HashMap;
import java.util.Map;

public class GridTraveler {

    static Map<Pair,Integer> solutionMap = new HashMap<>();

    public static int gridTravel(int n, int m) {
        if(n == 0 || m == 0) {
            return 0;
        }else if(n==1 || m ==1) {
            return 1;
        }
        if(solutionMap.containsKey(Pair.of(n,m))){
            return solutionMap.get(Pair.of(n,m));
        }
        int value = gridTravel(n-1,m) + gridTravel(n,m-1);
        solutionMap.put(Pair.of(n,m),value);
        return value;
    }

    public static void main(String[]args) {
        System.out.println(gridTravel(3,3));
    }
}
