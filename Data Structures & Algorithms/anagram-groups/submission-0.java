class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //map을 사용해서 
        //기본 원리는 strs에 있는 각단어를 sorted해서 같은 것 끼리 map에 올리면 되서
        //마지막 맵을 array로 바꿔서 return
        Map<String, List<String>> anagrams = new HashMap<>();

        //iterate through each word in strs
        for(String word : strs){
            //각 단어를 char array로 바꿔주고
            char[] chars = word.toCharArray();
            //그 array를 sort
            Arrays.sort(chars);

            //정렬된 char array를 string으로 다시 변환
            String key = new String(chars);
            //map에 없으면 새로 만들고
            anagrams.putIfAbsent(key, new ArrayList<>());
            //지금 단어 map에 올려놓기
            anagrams.get(key).add(word);
        }
        //다 map에 올려난 후 List<List<String>>으로 바꾼후 return
        return new ArrayList<>(anagrams.values());
    }
}
