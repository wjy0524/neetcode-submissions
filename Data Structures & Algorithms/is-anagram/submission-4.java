class Solution {
    public boolean isAnagram(String s, String t){
        //먼저 안에 character 보기에 앞서 길이가 다르면 그건 anagram이 될 수 가 없음
        if(s.length() != t.length()) return false;

        //s, t string -> char array로 바꾸기
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        //.sort() (오름차순으로)
        //java에서 array sort하는 법
        //Arrays.sort(charS)
        //Arrays.sort(charT)
        Arrays.sort(charS);
        Arrays.sort(charT);

        //다시 array -> String
        String sortedS = new String(charS);
        String sortedT = new String(charT);

        //그래서 그렇게 만들어진 strings이 같으면 그건 anagram이라는 거임
        if(sortedS.equals(sortedT)) return true;

        return false;
        
    }
}
