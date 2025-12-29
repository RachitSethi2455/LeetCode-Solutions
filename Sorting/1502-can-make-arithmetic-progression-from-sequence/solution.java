class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int prog = arr[1] - arr[0];
        for(int i=0;i<arr.length -1;i++){
            int diff = arr[i+1] - arr[i];
            if(diff == prog){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
}