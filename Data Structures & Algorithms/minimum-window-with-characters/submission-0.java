class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        Map<Character, Integer> tAlpha = new HashMap<>();
        //현재 window가 갖고 있는 alpha Map
        Map<Character, Integer> windowMap = new HashMap<>();
        //freq of alphabets in t are put into the hashmap
        for(char c : t.toCharArray()) tAlpha.put(c, tAlpha.getOrDefault(c, 0) + 1);

        int left = 0;
        int right = 0;

        int minLen = Integer.MAX_VALUE;
        int start = 0; 

        int need = tAlpha.size();
        int have = 0;

        //기본적인 알고리즘
        //right를 오른쪽으로 한칸씩 늘리면서 늘리다가 t를 다 포함하게 되면 그때부터 줄이기 시작하자
        while(right < s.length()){
            //현재 char이 tAlpha에있는건지 확인
            if(tAlpha.containsKey(s.charAt(right))){
                windowMap.put(s.charAt(right), windowMap.getOrDefault(s.charAt(right), 0) + 1);
                if(windowMap.get(s.charAt(right)).equals(tAlpha.get(s.charAt(right)))){
                    have++;
                }
            }

            //만약에 다 포함하게 됬어 이제 최소한으로 줄여야지
            while(need == have){
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    start = left;
                }

                char curChar = s.charAt(left);
                if(tAlpha.containsKey(curChar)){
                    // 2. 창에서 왼쪽 문자 하나 빼기
                    windowMap.put(curChar, windowMap.get(curChar) - 1);
                    // 3. 필요한 개수보다 작아지면 이 문자는 더 이상 충족되지 않음
                    if (windowMap.get(curChar) < tAlpha.get(curChar)) {
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
