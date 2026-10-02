class Solution {
    void helper(String curr, int open , int close, int n){

        if(open == n && close == n){
            res.add(curr);// only adds after string build is complete
            return;
        }

        if(open < n){
            helper(curr+"(" , open +1 , close,n);// exploring open braces
        }

        if(close < open){
            helper(curr+")" , open , close +1,n);// exploring all the closing bracket opts
        }
    }

    ArrayList<String> res = new ArrayList<>();// outside so that helper can use it

    public List<String> generateParenthesis(int n) {

        res.clear();
        helper("", 0, 0, n);
        return res;

    }
}