class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        /*ArrayList<Integer> l = new ArrayList<>();
        int count =0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 1){
                count++;
            }
            else{
                l.add(count);
                count = 0;
            }
            l.add(count);
        }
        int cons = Collections.max(l);
        return cons;*/
        int count =0;
        int max =0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 1){
                count++;
                max = Math.max(max,count);
            }
            else{
                count = 0;
            }
        }
        return max;
    }
}