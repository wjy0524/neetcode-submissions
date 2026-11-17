class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        Map<Character, Integer> tAlpha = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        for(char c : t.toCharArray()) tAlpha.put(c, tAlpha.getOrDefault(c, 0) + 1);

        int left = 0;
        int right = 0;

        int have = 0;
        int need = tAlpha.size();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while(right < s.length()){
            char curChar = s.charAt(right);
            if(tAlpha.containsKey(curChar)){
                windowMap.put(curChar, windowMap.getOrDefault(curChar, 0) + 1);
                if(windowMap.get(curChar).equals(tAlpha.get(curChar))){
                    have++;
                }
            }

            while(need == have){
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    start = left;
                }

                char curC = s.charAt(left);
                if(tAlpha.containsKey(curC)){
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
