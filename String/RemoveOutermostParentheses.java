package String;

public class RemoveOutermostParentheses {

    public static String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int openCount = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (openCount > 0) { // not the outermost '('
                    result.append(c);
                }
                openCount++;
            } else { // ')'
                openCount--;
                if (openCount > 0) { // not the outermost ')'
                    result.append(c);
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())")); // Output: ()()()
        System.out.println(removeOuterParentheses("(()())(())(()(()))")); // Output: ()()()()(())
        System.out.println(removeOuterParentheses("()()")); // Output: ""
    }
}

