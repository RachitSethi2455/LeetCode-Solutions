class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> s= new HashSet<Integer>();
        for(int i =0; i< candyType.length; i++){
            s.add(candyType[i]);
        }
        int maxAllowed = candyType.length / 2;
        return Math.min(s.size(), maxAllowed);
    }
}