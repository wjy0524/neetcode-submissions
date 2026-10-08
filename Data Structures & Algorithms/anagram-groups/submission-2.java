class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //key is sorted String 
        //value is list of original strings
        Map<String, List<String>> mapAnagrams = new HashMap<>();

        for(String word : strs){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedKey = new String(chars);
            mapAnagrams.putIfAbsent(sortedKey, new ArrayList<>());
            mapAnagrams.get(sortedKey).add(word);
        }

        //change map into ArrayList
        List<List<String>> answer = new ArrayList<>(mapAnagrams.values());
        return answer;

    }
}
