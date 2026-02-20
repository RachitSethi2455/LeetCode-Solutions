class Solution {
    public int maxProfit(int[] prices) {
        /*int ans  = 0;
        for(int i = 0;i<prices.length-1;i++){
            for(int j = i+1;j<prices.length-1;j++){
                if(prices.length > 2){
                    if(prices[j]-prices[i] > ans){
                        ans = prices[j]-prices[i];
                    }
                    else{
                        continue;
                    }
                }
                else if(prices.length <= 2){
                    ans = prices[0];
                }
            }
        }
        return ans;*/
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // update minimum
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice; // update profit
            }
        }
        return maxProfit;
    }
}