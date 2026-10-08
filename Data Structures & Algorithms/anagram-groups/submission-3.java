class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String word : strs){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedKey = new String(chars);
            map.putIfAbsent(sortedKey, new ArrayList<>());
            map.get(sortedKey).add(word);
        }

        List<List<String>> answer = new ArrayList<>(map.values());
        return answer;
    }
}
