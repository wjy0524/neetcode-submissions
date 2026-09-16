class Solution {
    List<String> answer;
    //curString
    StringBuilder curString;

    public void findParent(int curOpen, int curClose, int n){
        //base case
        if(curOpen == n && curClose == n){
            answer.add(new String(curString));
            return;
        }

        //add curOpen if left (if it isn't left, then skip)
        if(curOpen != n){
            //you add it
            curString.append('(');
            findParent(curOpen+1, curClose, n);
            curString.deleteCharAt(curString.length()-1);

        }

        if(curClose != n && curClose < curOpen){
            //you add it
            curString.append(')');
            findParent(curOpen, curClose+1, n);
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
