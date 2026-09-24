class Solution {
    public int smallestIndex(int[] nums) {
        int sum =0;
        for(int i =0; i< nums.length ; i++){
            int num = nums[i];
            while(num > 0){
                int r = num % 10;
                sum += r;
                num = num /10;
            }
            if(sum == i){
                return i;
            }
            sum =0;
        }
        return -1;
    }
}