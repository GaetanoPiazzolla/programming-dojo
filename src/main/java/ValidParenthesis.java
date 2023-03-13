import java.util.Stack;

public class ValidParenthesis {

    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Every close bracket has a corresponding open bracket of the same type.
     *
     */
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (isClosedPar(c)) {
                if (stack.empty() || getOpenPar(c) != stack.pop()) {
                    return false;
                }
                continue;
            }
            stack.push(c);
        }

        return stack.empty();
    }

    public boolean isClosedPar(Character c) {
        return c == ')' || c == ']' || c == '}';
    }

    public Character getOpenPar(Character c) {
        switch (c) {
            case '}':
                return '{';
            case ']':
                return '[';
            case ')':
                return '(';
            default:
                return null;
        }
    }


}
