class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count =0;
        for(int i=0; i<= flowerbed.length -1; i++){
            if(flowerbed[i] == 0){
                Boolean left = (i == 0) || (flowerbed[i-1] == 0);
                Boolean right = (i == flowerbed.length -1) || (flowerbed[i+1] == 0);
                if(left && right){
                    flowerbed[i] = 1;
                    count++;
                    if(count >= n){
                        return true;
                    }
                }
            }
        }
        return count >= n;
    }
}