class Solution {
    List<List<String>> answer;
    List<String> partition;

    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public void findPartition(String s, int beginIdx, int endIdx){
        //base case when it curIdx is at the end of String
        if(beginIdx == s.length()){
            answer.add(new ArrayList<>(partition));
            return;
        }
        //pruninig to prevent Out of bounds exception
        if(endIdx > s.length()){  
            return;
        }

        String curString = s.substring(beginIdx, endIdx);
        //if it is palindrome, you can add it
        if(isPalindrome(curString)){
            partition.add(curString);
            findPartition(s, endIdx, endIdx+1);
            //backtrack
            partition.remove(partition.size()-1);
        }
        //if it is not palindrome, you move endIdx by 1
        findPartition(s, beginIdx, endIdx+1);
    }


    public List<List<String>> partition(String s) {
        answer = new ArrayList<>();
        partition = new ArrayList<>();

        findPartition(s, 0, 1);

        return answer;
    }
}
