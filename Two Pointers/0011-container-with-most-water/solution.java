class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxarea = 0;
        int area = 0;
        while(left < right){
            if(height[left] < height[right]){
                area = height[left] *(right-left);
                maxarea = Math.max(maxarea,area);
                left++;
            }
            else{
                area = height[right] *(right-left);
                maxarea = Math.max(maxarea,area);
                right--;
            }
        }
        return maxarea;
    }
}