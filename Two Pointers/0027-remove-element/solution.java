class Solution {
    public int removeElement(int[] nums, int val) {
        /*List<Integer> l = new ArrayList<>();
        for(int num : nums){
            l.add(num);
        }
        for(int num : nums){
            if(val == num){
                l.remove(Integer.valueOf(num));
            }
        }
        return l.size();*/
        int k = 0;
        for(int i =0; i<nums.length;i++){
            if(nums[i] != val){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}