class Solution {
    public String gcdOfStrings(String str1, String str2) {
        /*int sl2 = str2.length();
        StringBuilder result = new StringBuilder("");
        for(int i =0; i< sl2 ; i++){
            if(str1.charAt(i) == str2.charAt(i)){
                result.append(str2.charAt(i));
            }
        }
        return result.toString();*/
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }
        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}