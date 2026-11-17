class Solution {
    public String minWindow(String s, String t) {
        //pruning: if t is longer than s, then return ""
        if(s.length() < t.length()) return "";

        Map<Character, Integer> tAlpha = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        for(char c : t.toCharArray()){
            tAlpha.put(c, tAlpha.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;

        int need = tAlpha.size();
        int have = 0;

        int start = 0;
        int minLen = Integer.MAX_VALUE;

        while(right < s.length()){
            char curChar = s.charAt(right);
            if(tAlpha.containsKey(curChar)){
                windowMap.put(curChar, windowMap.getOrDefault(curChar, 0)+1);
                if(windowMap.get(curChar).equals(tAlpha.get(curChar))){
                    have++;
                }
            }

            //when it finds the string that includes all alphabets in t 
            //now we have to minimize that string by moving left pointer
            while(have == need){
                //check current size of String
                //if current size is smaller than minLen then update minlen
                if(right-left+1 < minLen){
                    minLen = right - left + 1;
                    start = left;
                }
                char curC = s.charAt(left);
                //if this curC is not one of the alphabets in t
                //then we don't need this in our final string return value
                if(tAlpha.containsKey(curC)){
                    //if it is now we have to decrement 
                    windowMap.put(curC, windowMap.get(curC)-1);
                    if(windowMap.get(curC) < tAlpha.get(curC)){
                        have--;
                    }
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
