class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int[] cnt = new int[26];
        int maxFreq = 0;

        for(int right=0; right<s.length(); right++){
            char c = s.charAt(right);
            cnt[c - 'A']++;
            maxFreq = Math.max(maxFreq, cnt[c - 'A']);
            if(right - left + 1 - maxFreq > k){
                cnt[s.charAt(left) - 'A']--;
                left++;
            }

        }

        return s.length() - left;
        

    }
}
