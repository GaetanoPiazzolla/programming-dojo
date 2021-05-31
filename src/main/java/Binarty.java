public class Binarty {

    public static int solution(String S) {

        int operations = 0;

        while(S.startsWith("0"))
            S=S.substring(1);

        for(int i=0;i<S.length();i++)
        {
            if(S.charAt(i)=='1')
            {
                operations++;
            }
        }

        return operations + S.length();

    }

    /**
     * For a given string return the number of operation we need to do to reduce the string to 0
     * an operation can be a division by 2 or a -1.
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(solution("011100"));

    }
}
