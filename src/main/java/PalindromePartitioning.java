import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        recursivePartition(0, s, list, new ArrayList<>());
        return list;
    }

    private static void recursivePartition(int start, String s, List<List<String>> list, List<String> current) {

        if (s.length() == start) {
            list.add(new ArrayList<>(current));
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {

            String pre = s.substring(start, i);

            if (isPalindrome(pre)) {
                current.add(pre);
                recursivePartition(i, s, list, current);
                current.remove(current.size() - 1);
            }


        }

    }

    private static boolean isPalindrome(String substring) {
        for (int i = 0; i < substring.length() / 2; i++) {
            if (substring.charAt(i) != substring.charAt(substring.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(partition("cacca"));

    }

}
