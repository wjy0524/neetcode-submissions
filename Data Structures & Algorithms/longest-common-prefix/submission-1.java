class Solution {
    public String longestCommonPrefix(String[] strs) {
        for(int i=0; i<strs[0].length(); i++){
            for(String s : strs){
                if(i == s.length() || strs[0].charAt(i) != s.charAt(i)){
                    return s.substring(0, i);
                }
            }
        }

        return strs[0];
    }
}