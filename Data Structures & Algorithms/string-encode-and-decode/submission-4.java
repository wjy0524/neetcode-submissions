class Solution {

    public String encode(List<String> strs) {
        //encoding이란 단어 여러개의 arrayList strs가 주어질떄
        //그걸 암호화해서 한 string의 형태로 변형시키는 것
        //암호화 방법: 단어길이#실제단어 이런식으로 이을 거임
        //string은 java에서 immutable so has to use StringBuilde
        StringBuilder sb = new StringBuilder();
        for(String word : strs){
            sb.append(word.length()).append("#").append(word);
        }
        //now have to change stringbuilder to String
        return sb.toString();

    }

    public List<String> decode(String str) {
        //이제 아까 암호화된 (단어길이#실제단어) 얘를 풀어서 List<String> 형태로 return 해야해
        List<String> result = new ArrayList<>();

        int idx = 0;

        //# = delimiter
        while(idx < str.length()){
            int delimiterIdx = str.indexOf("#", idx);
            int wordLen = Integer.parseInt(str.substring(idx, delimiterIdx));

            //단어를 이제 result에 올리기
            result.add(str.substring(delimiterIdx+1, delimiterIdx+wordLen+1));

            //idx update
            idx = delimiterIdx + wordLen +1;
        }

        //return the ArrayList of the words
        return result;
    }
}
