class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> countS = new HashMap<>();
        Map<Character, Integer> countT = new HashMap<>();

        //before counting each letter for each string
        //if the length of s and t are different, then it should return false
        if(s.length() != t.length()) return false;

        //count letters for string s
        for(int i=0; i<s.length(); i++){
            //if it already exists ing countS map
            if(countS.containsKey(s.charAt(i))){
                countS.put(s.charAt(i), countS.get(s.charAt(i)) + 1);
            }//if it doesn't exist 
            else{
                countS.put(s.charAt(i), 1);
            }
        }

        //count letters for string t
        for(int i=0; i<t.length(); i++){
            //if it already exists ing countT map
            if(countT.containsKey(t.charAt(i))){
                countT.put(t.charAt(i), countT.get(t.charAt(i)) + 1);
            }//if it doesn't exist 
            else{
                countT.put(t.charAt(i), 1);
            }
        }

        //return true if countS is the same with countT
        return countS.equals(countT);

    }
}
