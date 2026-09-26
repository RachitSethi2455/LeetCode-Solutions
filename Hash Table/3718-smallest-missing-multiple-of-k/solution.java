class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet <Integer> s = new HashSet<>();
        for(int num : nums){
            s.add(num);
        }
        int miss = k;
        while(s.contains(miss)){
            miss += k;
        }
        return miss;
    }
}