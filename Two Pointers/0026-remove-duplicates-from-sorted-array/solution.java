class Solution {
    public int removeDuplicates(int[] nums) {
        /*List<Integer> l = new ArrayList<>();
        for(int i =0; i< nums.length -1; i ++){
            for(int j =1; i< nums.length -1; i ++){
                if(nums[i] == nums[j]){
                    continue;
                }
                else{
                    l.add(nums[i]);
                }
            }
        }
        return l.size();*/
        if(nums.length == 0) return 0;
        int i =0;
        for(int j =1;j<nums.length;j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}