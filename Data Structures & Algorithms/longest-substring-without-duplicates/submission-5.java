class Solution {
    public int lengthOfLongestSubstring(String s) {
        int mxLen = 0;
        int left = 0;

        Set<Character> alpha = new HashSet<>();

        for(int right=0; right<s.length(); right++){
            while(alpha.contains(s.charAt(right))){
                alpha.remove(s.charAt(left));
                left++;
            }
            alpha.add(s.charAt(right));
            mxLen = Math.max(mxLen, right-left+1);
        }

        return mxLen;
    }
}
