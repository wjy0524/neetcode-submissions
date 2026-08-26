class Solution {
    public boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;

        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        Arrays.sort(charS);
        Arrays.sort(charT);

        String sortedS = new String(charS);
        String sortedT = new String(charT);

        if(sortedS.equals(sortedT)) return true;

        return false;
        
    }
}
