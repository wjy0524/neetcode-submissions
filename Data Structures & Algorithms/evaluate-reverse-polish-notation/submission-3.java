class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int t=0; t<tokens.length; t++){
            //operand라면
            if(tokens[t].equals("+") || tokens[t].equals("-") || tokens[t].equals("*") || tokens[t].equals("/")){
                int sNum = stack.pop();
                int fNum = stack.pop();
                //계산을 하고 다시 넣어야지
                if(tokens[t].equals("+")){
                    stack.push(fNum + sNum);
                }else if(tokens[t].equals("-")){
                    stack.push(fNum - sNum);
                }else if(tokens[t].equals("*")){
                    stack.push(fNum * sNum);
                }else{
                    stack.push(fNum / sNum);
                }
            }else{
                //operand가 아니라 숫자면 그냥 push
                stack.push(Integer.parseInt(tokens[t]));
            }
        }
        //마지막이면 마지막 stack에 올라와있는게 마지막 답
        return stack.pop();
    }
}
