class Solution {
    public String validIPAddress(String queryIP) {
        if(queryIP.contains(".")){
            String[] parts = queryIP.split("\\.",-1);
            if(parts.length != 4){
                return "Neither";
            }
            for(String val : parts){
                if(val.length() ==0){
                    return "Neither";
                }
                if(val.length()>1 && val.charAt(0) == '0'){
                    return "Neither";
                }
                for(char c : val.toCharArray()){
                    if(!Character.isDigit(c)){
                        return "Neither";
                    }
                }
                if(val.length()>3){
                    return "Neither";
                }
                if(Integer.parseInt(val)>255){
                    return "Neither";
                }
            }
            return "IPv4";
        }
        else if(queryIP.contains(":")){
            String[] parts = queryIP.split(":",-1);
            if(parts.length != 8){
                return "Neither";
            }
            for(String val : parts){
                if(val.length()<1 || val.length()>4){
                    return "Neither";
                }
                for(char c : val.toCharArray()){
                    if(!Character.isDigit(c) && !(c >= 'a' && c<= 'f') &&
                    !(c >= 'A' && c<= 'F')){
                    return "Neither";
                    }
                }
            }
            return "IPv6";
        }
        else{
            return "Neither";
        }
    }
}