class Solution {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        
        //make a Stack
        Deque<Character> stack = new ArrayDeque<>();


        for(int i=0; i<chars.length; i++){
            if(chars[i] == '(' || chars[i] == '{' || chars[i] == '['){
                stack.push(chars[i]);
            }else{
                if(stack.isEmpty()) return false;
                Character curFromStack = stack.pop();
                Character curFromS = ' ';
                if(chars[i] == ')') curFromS = '(';
                if(chars[i] == ']') curFromS = '[';
                if(chars[i] == '}') curFromS = '{';
                if(!curFromStack.equals(curFromS)) return false;
                
            }
        }

        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }

    }
}
