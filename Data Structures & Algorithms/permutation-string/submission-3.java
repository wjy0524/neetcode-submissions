class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //만약 s1이 s2보다 길다면 애당초 s1이 s2안에 substring수가 없음
        //pruning
        if(s1.length() > s2.length()) return false;
        //s1Cnt for counting each alphabet in s1
        int[] s1Cnt = new int[26];
        //this is sliding window that counts each alphabet in the window with the fixed sixe of windowSize
        int[] s2Window = new int[26];
        
        //cnt s1
        for(char c : s1.toCharArray()){
            s1Cnt[c-'a']++;
        }

        int windowSize = s1.length();

        //try the very first window
        for(int i=0; i<windowSize; i++){
            s2Window[s2.charAt(i)-'a']++;
        }
        //if theya re the same, return true;
        if(Arrays.equals(s1Cnt, s2Window)){
            return true;
        }

        int left = 0;
        //window size is fixed as windowSize
        //so increment leftIdx and rigthIdx by 1
        for(int right=windowSize; right<s2.length(); right++){
            s2Window[s2.charAt(left)-'a']--;
            s2Window[s2.charAt(right)-'a']++;

            //if they are teh same then yes, return true
            if(Arrays.equals(s1Cnt, s2Window)){
                return true;
            }

            left++;
        }

        //after checking every window, if they were no mathcings
        //then return false;
        return false;
    }
}
