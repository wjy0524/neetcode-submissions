class Solution {

    public String encode(List<String> strs) {
        //delimiter #
        //기본적인 형태는 단어길이#단어
        StringBuilder sb = new StringBuilder();
        for(String word : strs){
            sb.append(word.length()).append("#").append(word);
        }

        return sb.toString();

    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i=0; 
        while(i<str.length()){
            int delimitIdx = str.indexOf("#", i);
            int wordLength = Integer.parseInt(str.substring(i, delimitIdx));
            result.add(str.substring(delimitIdx+1, delimitIdx + wordLength+1));
            i = delimitIdx+wordLength+1;
        }

        return result;
    }
}
