class Solution {
    public int scoreOfParentheses(String s) {
        /*int score =0;
        Stack<Character> stack = new Stack<>();
        for(int i =0; i< s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            }
            else{
                stack.pop();
                score++;
            }
        }
        return score;*/
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i =0; i< s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(0);
            }
            else{
                int inside = stack.pop();
                int val;
                if(inside == 0){
                    val=1;
                }
                else{
                    val = 2*inside;
                }
                int previous = stack.pop();
                stack.push(previous + val);
            }
        }
        return stack.pop();
    }
}