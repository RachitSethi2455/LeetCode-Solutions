class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> l = new ArrayList<>();
        double result;
        
        for(int num : nums1){
            l.add(num);
        }
        for(int num : nums2){
            l.add(num);
        }
        Collections.sort(l);
        if((nums1.length + nums2.length)%2 == 0){
            double a = l.get((nums1.length + nums2.length)/2);
            double b = l.get(((nums1.length + nums2.length)/2)-1);
            result = (a+b)/2;
        }
        else{
            result = l.get((nums1.length + nums2.length)/2);
        }
        return result;
    }
}