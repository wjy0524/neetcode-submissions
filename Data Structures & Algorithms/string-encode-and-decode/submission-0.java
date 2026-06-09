class Solution {
    //delimiter #

    public String encode(List<String> strs) {
        //encoding하는 기본적인 방식 
        //길이#"실제단어"
        StringBuilder sb = new StringBuilder();
        for(String word : strs){
            sb.append(word.length()).append("#").append(word);
        }

        //now have to convert stringbuilder to actual string and return it
        return sb.toString();

    }

    public List<String> decode(String str) {
        //반대는 먼저 #이 올때까지의 단어 길이를 읽어야함
        List<String> decoded_strs = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            //먼저 #의 index를 찾아야함
            //indexOf(String, int) 는 i 위치부터 # 을 찾음
            int hashIdx = str.indexOf("#", i);
            int wordLength = Integer.parseInt(str.substring(i, hashIdx));
            //그럼 실제 단어는 hashIdx+1부터 hashIdx+1+wordLength까지임 그걸 decoded_strs에 올리면 됨
            decoded_strs.add(str.substring(hashIdx+1, hashIdx+1+wordLength));
            //i update
            i = hashIdx+1+wordLength;

        }

        return decoded_strs;
    }
}
