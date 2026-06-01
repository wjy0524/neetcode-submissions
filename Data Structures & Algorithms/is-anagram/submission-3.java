class Solution {
    public boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;

        //각각의 단어를 char array로 바꾼후 sort한후 비교하면 됨
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();

        Arrays.sort(charsS);
        Arrays.sort(charsT);

        String sortedS = new String(charsS);
        String sortedT = new String(charsT);
        
        return sortedS.equals(sortedT);

    }
}
