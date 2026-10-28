class Solution {
    public List<Integer> partitionLabels(String s) {
        //what if i made a map where key is the character, and value is the last index of that Character
        Map<Character, Integer> charMap = new HashMap<>();

        List<Integer> answer = new ArrayList<>();

        for(int i=0; i<s.length(); i++){
            charMap.put(s.charAt(i), i);
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, charMap.get(s.charAt(i)));  
            //it's done. now you can end wih that substring
            if (i == end) {                                  
                answer.add(end - start + 1);
                start = i + 1;
            }
        }

        return answer;
    }
}
