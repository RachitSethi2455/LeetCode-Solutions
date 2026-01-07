class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        String vowel = "aeiouAEIOU";
        List<Character> vowelList = new ArrayList<>();
        for(char c : ch){
            if(vowel.indexOf(c) != -1){
                vowelList.add(c);
            }
        }
        Collections.reverse(vowelList);
        
        int idx =0;
        for(int i =0; i< ch.length ; i++){
            if (vowel.indexOf(ch[i]) != -1){
                ch[i] = vowelList.get(idx++);
            }
        }
        return new String(ch);
    }
}