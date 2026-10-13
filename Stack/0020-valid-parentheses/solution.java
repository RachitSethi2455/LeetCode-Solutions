class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int l = s.length();
        for(int i =0; i< l; i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if((c == ')' && top != '(') || (c == ']' && top != '[') || 
                (c == '}' && top != '{')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}