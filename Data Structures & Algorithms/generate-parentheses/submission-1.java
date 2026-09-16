class Solution {
    //well-formed parentheses: 지금 까지 만들어진 거 기준으로 )의 개수가 (의 개수보다 많으면 안됨
    //answer
    List<String> answer;
    StringBuilder curString;
    public void findParent(int open, int close, int n){
        //base case 종료 조건 open == n and close == n
        if(open == n && close == n){
            //curString을 string으로 변환후 answer에 올려야함
            answer.add(new String(curString));
            return;
        }

        //open 남아있으면
        if(open != n){
            //( 를 curString에 추가한다
            curString.append('(');
            findParent(open+1, close, n);
            curString.deleteCharAt(curString.length()-1);
        }

        //close가 남아있고 현재까지 curstring에 (의 개수가 )의 개수보다 많으면
        if(close != n && close < open){
            curString.append(')');
            findParent(open, close+1, n);
            curString.deleteCharAt(curString.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        answer = new ArrayList<>();
        curString = new StringBuilder();

        findParent(0, 0, n);

        return answer;
        
    }
}
