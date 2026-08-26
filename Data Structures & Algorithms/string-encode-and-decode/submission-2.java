class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        //단어길이#단어
        for(String word : strs){
            sb.append(word.length()).append("#").append(word);
        }

        //그렇게 만들어진 encoded string을 return
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        int idx = 0;
        
        while(idx < str.length()){
            //# is a delimiter
            int delimitIdx = str.indexOf("#", idx);
            int wordLen = Integer.parseInt(str.substring(idx, delimitIdx));
            result.add(str.substring(delimitIdx+1, delimitIdx+1+wordLen));
            //update the idx
            idx = delimitIdx + wordLen + 1;

        }

        return result;
        
    }
}
