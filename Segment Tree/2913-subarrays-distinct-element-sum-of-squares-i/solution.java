class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans=0;
        for(int i =0; i < nums.size() ; i++){
            HashSet<Integer> m = new HashSet<>();
            for(int j =i; j< nums.size() ; j++){
                m.add(nums.get(j));

                int distinct = m.size();
                ans += distinct * distinct;
            }
        }
        return ans;
    }
}