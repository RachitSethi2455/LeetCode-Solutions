class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i =0; i < nums.length; i++){
            pq.offer(nums[i]);
        }
        while(k>1){
            pq.poll();
            k--;
        }
        return pq.peek();
    }
}