class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum ==0 || sum > 9* num){
            return "";
        }
        StringBuilder s = new StringBuilder();
        for(int i =0; i < num;i++){
            if(sum >= 9){
                s.append('9');
                sum -=9;
            }
            else{
                s.append((char) ('0' + sum));
                sum = 0;
            }
        }
        return s.toString();
    }
}