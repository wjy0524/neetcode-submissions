class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        HashSet<String> wordSet = new HashSet<>();
        for(String word : wordList) wordSet.add(word);
        //purpose of this program:
        //transform beginWord into endWord
        //rules of transformation:
        // - You may transform beginWord to any word within wordList, provided that at exactly one position the words have a different character, and the rest of the positions have the same characters.
        // - You may repeat the previous step with the new word that you obtain, and you may do this as many times as needed.
        // answer, initialized as infinity

        int minTransform = 0;

        Deque<String> q = new ArrayDeque<>();
        q.offer(beginWord);

        while(!q.isEmpty()){
            int curLevelSize = q.size();

            for(int i=0; i<curLevelSize; i++){
                String curWord = q.poll();
                char[] curWordArray = curWord.toCharArray();
                for(int j=0; j<curWordArray.length; j++){
                    char ogChar = curWordArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {               // 넣어볼 문자            
                        curWordArray[j] = c;
                        String transformedWord = new String(curWordArray);
                        if(transformedWord.equals(endWord)){
                            return minTransform + 2;
                        }
                    //check if set has this
                        if(wordSet.contains(transformedWord)){
                        //있으면 변형 하자 그리고 queue에 넣자
                            q.offer(transformedWord);
                        //set에서 제거하자
                            wordSet.remove(transformedWord);
                        }
                    //다시 복구
                        curWordArray[j] = ogChar;
        
                    }
                }
            }
            minTransform++;
        }
        return 0;

    }

    
}
