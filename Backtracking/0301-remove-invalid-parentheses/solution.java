class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {

        int open = 0;
        int close = 0;

        // Find minimum number of '(' and ')' to remove
        for (char c : s.toCharArray()) {

            if (c == '(') {
                open++;
            }
            else if (c == ')') {

                if (open > 0) {
                    open--;
                }
                else {
                    close++;
                }
            }
        }

        backtrack(s, 0, open, close, 0, new StringBuilder());

        return ans;
    }

    void backtrack(String s, int index,
                   int openToRemove, int closeToRemove,
                   int balance, StringBuilder curr) {

        // Invalid prefix
        if (balance < 0) {
            return;
        }

        // End of string
        if (index == s.length()) {

            if (openToRemove == 0 &&
                closeToRemove == 0 &&
                balance == 0) {

                String result = curr.toString();

                if (!ans.contains(result)) {
                    ans.add(result);
                }
            }

            return;
        }

        char c = s.charAt(index);

        // Letter: must keep it
        if (c != '(' && c != ')') {

            curr.append(c);

            backtrack(s, index + 1,
                      openToRemove, closeToRemove,
                      balance, curr);

            curr.deleteCharAt(curr.length() - 1);

        }

        // '('
        else if (c == '(') {

            // Option 1: remove '('
            if (openToRemove > 0) {

                backtrack(s, index + 1,
                          openToRemove - 1,
                          closeToRemove,
                          balance, curr);
            }

            // Option 2: keep '('
            curr.append('(');

            backtrack(s, index + 1,
                      openToRemove,
                      closeToRemove,
                      balance + 1,
                      curr);

            curr.deleteCharAt(curr.length() - 1);
        }

        // ')'
        else {

            // Option 1: remove ')'
            if (closeToRemove > 0) {

                backtrack(s, index + 1,
                          openToRemove,
                          closeToRemove - 1,
                          balance, curr);
            }

            // Option 2: keep ')'
            curr.append(')');

            backtrack(s, index + 1,
                      openToRemove,
                      closeToRemove,
                      balance - 1,
                      curr);

            curr.deleteCharAt(curr.length() - 1);
        }
    }
}