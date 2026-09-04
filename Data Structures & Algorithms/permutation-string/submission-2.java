class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] s1Cnt = new int[26];
        int[] s2Window = new int[26];

        for(char c : s1.toCharArray()){
            s1Cnt[c-'a']++;
        }

        int windowSize = s1.length();

        for(int i=0; i<windowSize; i++){
            s2Window[s2.charAt(i)-'a']++;
        }

        if(Arrays.equals(s1Cnt, s2Window)){
            return true;
        }
        int left = 0;
        for(int right=windowSize; right<s2.length(); right++){
            s2Window[s2.charAt(left)-'a']--;
            s2Window[s2.charAt(right)-'a']++;

            if(Arrays.equals(s1Cnt, s2Window)){
                return true;
            }

            left++;
        }

        return false;
    }
}
