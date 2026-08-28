class MinStack {

    //global var
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        //일반 스택과 minStack 따로 관리 해주자
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        //일단 일반 스택에 push
        stack.push(val);
        //minstack과 같은경우
        //새로운 val이 기존 min val보다 작으면 그걸 올리고
        if(minStack.isEmpty() || minStack.peek() >= val){
            minStack.push(val);
        }else{//크면 그냥 기존의 min을 다시 minStack에 push
            minStack.push(minStack.peek());
        }
    }
    
    //pop은 둘다 그냥 pop
    public void pop() {
        stack.pop();
        minStack.pop();
        
    }
    
    //stack peek
    public int top() {
        return stack.peek();
    }
    //minstack peek
    public int getMin() {
        return minStack.peek();
    }
}
