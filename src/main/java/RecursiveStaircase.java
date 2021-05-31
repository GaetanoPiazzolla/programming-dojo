public class RecursiveStaircase {

    public static int n_ways(int n) {
        return recursive(n);
    }

    private static int recursive(int n) {
        int numWays =0;
        if(n==0)
        {
            numWays++;
        }
        else if(n<0){
            numWays=0;
        }
        else {
            numWays+=recursive( n-1);
            numWays+=recursive( n-2);
        }
        return numWays;
    }

    public static void main(String[] args)
    {
        // 1,2,3,4 - 2,4 - 1,2,4 - 2,3,4 - 1,3,4
        System.out.println(n_ways(4));

        // 1,2 - 2
        System.out.println(n_ways(2));

        // 1,2,3 - 1,3 - 2,3
        System.out.println(n_ways(3));
    }
}
