class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<tokens.length; i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                Integer newNum;
                if(tokens[i].equals("+")){
                    newNum = num1 + num2;
                }else if(tokens[i].equals("-")){
                    newNum = num1 - num2;
                }else if(tokens[i].equals("*")){
                    newNum = num1 * num2;
                }else{
                    newNum = num1 / num2;
                }
                stack.push(newNum);
            }else{
                //숫자라면
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();
    }
}
