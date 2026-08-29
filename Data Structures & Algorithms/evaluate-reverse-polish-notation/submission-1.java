class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(int idx=0; idx<tokens.length; idx++){ //operand이라면
            if(tokens[idx].equals("+") || tokens[idx].equals("-") || tokens[idx].equals("*") || tokens[idx].equals("/")){
                int sNum = stack.pop();
                int fNum = stack.pop();
                if(tokens[idx].equals("+")){
                    stack.push(fNum+sNum);
                }else if(tokens[idx].equals("-")){
                    stack.push(fNum-sNum);
                }else if(tokens[idx].equals("*")){
                    stack.push(fNum*sNum);
                }else if(tokens[idx].equals("/")){
                    stack.push(fNum / sNum);
                }
            }else{ //숫자라면
                stack.push(Integer.parseInt(tokens[idx]));
            }
        }

        return stack.pop();
    }
}
