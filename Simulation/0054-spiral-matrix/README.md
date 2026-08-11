# 54. Spiral Matrix

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/spiral-matrix/)

`Array` · `Matrix` · `Simulation`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Matrix, Simulation.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        List<Integer> spiral = new ArrayList<>();
        while(top<=bottom && left<=right){
            for(int i = left; i<= right; i++){
                spiral.add(matrix[top][i]);
            }
            top++;
            for(int j = top; j<= bottom;j++){
                spiral.add(matrix[j][right]);
            }
            right--;
            if(top<=bottom){
                for(int k = right;k>=left; k--){
                    spiral.add(matrix[bottom][k]);
                }
                bottom--;
            }
            if(left<=right){
                for(int l = bottom; l>= top;l--){
                    spiral.add(matrix[l][left]);
                }
                left++;
            }
        }
        return spiral;
    }
}
```

---

**Runtime** 0 ms · **Memory** 42.7 MB

<sub>Synced by AILeetHub on 2026-08-11.</sub>
