class Solution {
    public boolean containsDuplicate(int[] nums) {
        /*for(int i =0; i<nums.length; i++){
            for(int j =i+1; j<nums.length;j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }*/
        HashSet<Integer> set = new HashSet<>();
        int i =0;
        while(i < nums.length){
            if(set.contains(nums[i])){
                return true;
            }
            else{
                set.add(nums[i]);
                i++;
            }
        }
        return false;
    }
}