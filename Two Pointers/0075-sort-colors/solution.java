class Solution {
    public void sortColors(int[] nums) {
       int[] ar = new int[nums.length];
       int s=0;
       int e=nums.length-1;
       for(int i=0;i<nums.length;i++){
        if(nums[i]==0){
            ar[s]=nums[i];
            s++;
        }
        else if(nums[i]==2){
            ar[e]=nums[i];
            e--;
        }
       }
       for(int j=s;j<=e;j++){
        ar[j]=1;
       }
       for(int k =0;k<nums.length;k++){
        nums[k]=ar[k];
       }
    }
}