import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: ["()"]
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis p = new GenerateParenthesis();
        System.out.println(p.generateParenthesis(4));
    }

    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        recursive(results, n, 0, 0, "");
        return results;
    }

    private void recursive(List<String> results, int n, int closed, int opened, String current) {

        if (closed == n && opened == n) {
            results.add(current);
            return;
        }

        if (opened < n) {
            recursive(results, n, closed, opened + 1, current + '(');
        }

        if (opened > closed) {
            recursive(results, n, closed + 1, opened, current + ')');
        }
    }

}
