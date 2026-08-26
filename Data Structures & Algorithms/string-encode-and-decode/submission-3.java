class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        //encoded 저장 형태 단어길이#실제단어
        for(String word : strs){
            sb.append(word.length()).append("#").append(word);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        int idx = 0;
        while(idx < str.length()){
            int delimitIdx = str.indexOf("#", idx);
            int wordLen = Integer.parseInt(str.substring(idx, delimitIdx));
            result.add(str.substring(delimitIdx+1, delimitIdx+wordLen+1));

            idx = delimitIdx + wordLen + 1;
        }

        return result;
    }
}
