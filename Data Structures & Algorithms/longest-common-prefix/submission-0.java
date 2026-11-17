class Solution {
    public String longestCommonPrefix(String[] strs) {
        for (int i = 0; i < strs[0].length(); i++) {
            for (String s : strs) {
                if (i == s.length() || s.charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);   // 0 ~ i-1까지가 공통
                }
            }
        }
        return strs[0];   // strs[0] 전체가 공통 접두사
    }
}