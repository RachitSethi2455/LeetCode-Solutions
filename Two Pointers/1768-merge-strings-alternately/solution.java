class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        StringBuilder result=new StringBuilder("");
        int max = Math.max(word1.length(),word2.length());
        for(int i=0;i< max;i++){
            if(i<word1.length()){
                result.append(word1.charAt(i));
            }
            if(i<word2.length()){
                result.append(word2.charAt(i));
            }
        }return result.toString();
    }
}