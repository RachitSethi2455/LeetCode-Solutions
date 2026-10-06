class Solution {
    public int minAddToMakeValid(String s) {
        /*int open=0;
        int close=0;
        for(int i =0; i <s.length();i++){
            char c= s.charAt(i);
            if( c == '(' ){
                open++;
            }
            if( c == ')' ){
                close++;
            }
        }
        int res = Math.abs(open - close);
        return res;*/
        int open =0;
        int res =0;
        for(int i =0; i <s.length(); i++){
            char c = s.charAt(i);
            if (c == '('){
                open++;
            }
            else{
                if(open > 0){
                    open--;
                }
                else{
                    res++;
                }
            }
        }
        return open + res;
    }
}