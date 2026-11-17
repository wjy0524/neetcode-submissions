class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        char[] strS = s.toCharArray();
        char[] strT = t.toCharArray();

        Arrays.sort(strS);
        Arrays.sort(strT);

        String sortedS = new String(strS);
        String sortedT = new String(strT);

        if(sortedS.equals(sortedT)) return true;
        return false;
    }
}
