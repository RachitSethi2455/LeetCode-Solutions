class Solution {
    public int[] plusOne(int[] digits) {
        /*int len = digits.length;
        if(digits[len -1] != 9){
            digits[len- 1] = digits[len- 1] + 1;
        }
        else{
            for(int i =0; i<= digits.length;i++){
            }
        }
        return digits;*/
        int len = digits.length;
        for(int i = len-1;i>=0;i--){
            if(digits[i] < 9){
                digits[i] = digits[i] + 1;
                return digits;
            }
            digits[i]=0;
        }
        int[] res = new int[len+1];
        res[0] =1;
        return res;
    }
}