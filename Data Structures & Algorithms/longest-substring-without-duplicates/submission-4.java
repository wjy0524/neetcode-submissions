class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left =0;
        Set<Character> alphabets = new HashSet<>();
        for(int right=0; right<s.length(); right++){
            while(alphabets.contains(s.charAt(right))){
                alphabets.remove(s.charAt(left));
                left++;
            }
            alphabets.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left +1);
        }

        return maxLength;
    }
}
