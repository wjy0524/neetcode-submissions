class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        //including beginword -> next , some word -> endword these two transform
        int minTransform = 2;

        HashSet<String> wordSet = new HashSet<>(wordList);

        Deque<String> q = new ArrayDeque<>();
        q.offer(beginWord);

        while(!q.isEmpty()){
            int levelSize = q.size();
            for(int i=0; i<levelSize; i++){
                String curWord = q.poll();
                char[] curWordArray = curWord.toCharArray();
                for(int j=0; j<curWordArray.length; j++){
                    char ogChar = curWordArray[j];
                    for(char c = 'a'; c<= 'z'; c++){
                        curWordArray[j] = c;
                        String transformedWord = new String(curWordArray);
                        if(transformedWord.equals(endWord)){
                            return minTransform;
                        }
                        if(wordSet.contains(transformedWord)){
                            q.offer(transformedWord);
                            wordSet.remove(transformedWord);
                        }
                        curWordArray[j] = ogChar;
                    }
                }
            }
            minTransform++;
        }

        return 0;

    }
}
