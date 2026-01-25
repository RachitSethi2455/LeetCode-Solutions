class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m+n];
        int i=0;
        for(int num : nums1){
            if(i<m){
                ans[i] = num;
                i++;
            }
        }
        for(int nums : nums2){
            ans[i] = nums;
            i++;
        }
        Arrays.sort(ans);
        for (int idx = 0; idx < m+n; idx++) {
            nums1[idx] = ans[idx];
        }
    }
}