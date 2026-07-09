class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /*for(int i =0; i<nums.length; i++){
            for(int j =i+1; j<nums.length;j++){
                if(nums[i] == nums[j] && Math.abs(i-j)<=k){
                    return true;
                }
            }
        }*/
        HashMap<Integer,Integer> map = new HashMap<>();
        int i =0;
        while(i< nums.length){
            if(map.containsKey(nums[i])){
                int j = map.get(nums[i]);
                if(Math.abs(i-j)<= k){
                    return true;
                }
            }
            map.put(nums[i],i);
            i++;
        }
        return false;
    }
}