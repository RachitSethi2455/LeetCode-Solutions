class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x; // sqrt(0) = 0, sqrt(1) = 1
        }

        int left = 1;
        int right = x / 2; // sqrt(x) can't be more than x/2 for x > 1
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2; // avoid overflow
            long sq = (long) mid * mid; // use long to prevent overflow

            if (sq == x) {
                return mid; // perfect square
            } else if (sq < x) {
                ans = mid; // store candidate
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;



    }
}