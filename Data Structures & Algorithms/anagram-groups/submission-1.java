class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //일단 같은 anagram끼리 구분을 해줘야하는데 
        //구분한 걸 어떤 자료구조를 사용할 거냐: Map (key: sorted word, value: arrayList of actual word)
        Map<String, List<String>> anagramMap = new HashMap<>();

        for(String word : strs){
            char[] chars = word.toCharArray();

            //sort that char Array
            Arrays.sort(chars);
            //this is going to be key
            //make that char array to String to be a key
            String key = new String(chars);
            
            //putIfAbsent(key, value);
            //비어있다면 value를 넣어라
            anagramMap.putIfAbsent(key, new ArrayList<>());

            //그리고 map에 원본 단어 넣기
            anagramMap.get(key).add(word);
        }

        //return as a form of List<List<String>>
        return new ArrayList<>(anagramMap.values());
    }
}
