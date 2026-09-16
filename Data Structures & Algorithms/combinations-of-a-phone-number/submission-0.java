class Solution {
    List<String> answer;
    String[] letters = {
        "",     // 0 (사용 안 함)
        "",     // 1 (사용 안 함)
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    StringBuilder possLetter;

    public void findAllPossLetter(String digits, int curIdx){
        //base case
        if(curIdx == digits.length()){
            answer.add(new String(possLetter));
            return;
        }

        char d = digits.charAt(curIdx);
        int dig = d - '0'; 

        String digitToLetter = letters[dig];

        for(int idx=0; idx<digitToLetter.length(); idx++){
            possLetter.append(digitToLetter.charAt(idx));
            findAllPossLetter(digits, curIdx+1);
            possLetter.deleteCharAt(possLetter.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {
        possLetter = new StringBuilder();
        answer = new ArrayList<>();
        if(!digits.equals("")){
            findAllPossLetter(digits, 0);
        }
        return answer;
    }
}
