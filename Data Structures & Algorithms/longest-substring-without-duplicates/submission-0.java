class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();

        //length of longest substring which is the answer
        int maxLen = 0;

        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            while(window.contains(c)){
                //그럼 window에서 c가 나올때까지 window에서 문자들 삭제
                window.remove(s.charAt(left));
                left++;
            }

            window.add(c);
            maxLen = Math.max(maxLen, window.size());
        }


        return maxLen;
    }
}
