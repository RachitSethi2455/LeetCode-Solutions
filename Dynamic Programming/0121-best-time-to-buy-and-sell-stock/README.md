# 121. Best Time to Buy and Sell Stock

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

`Array` · `Dynamic Programming`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Dynamic Programming.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
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
```

---

**Runtime** 1 ms · **Memory** 94.6 MB

<sub>Synced by AILeetHub on 2026-02-20.</sub>
