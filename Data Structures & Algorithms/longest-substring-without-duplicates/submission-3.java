class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLen = 0;
        Set<Character> window = new HashSet<>();

        for(int right=0; right<s.length(); right++){
            char c = s.charAt(right);
            while(window.contains(c)){
                window.remove(s.charAt(left));
                left++;
            }
            window.add(c);
            maxLen = Math.max(maxLen, window.size());
        }

        return maxLen;
    }
}
