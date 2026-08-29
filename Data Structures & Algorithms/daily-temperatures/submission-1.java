class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for(int idx=0; idx<temperatures.length; idx++){
            while(!stack.isEmpty() && temperatures[idx] > temperatures[stack.peek()]){
                int day = stack.pop();
                result[day] = idx - day;
            }
            stack.push(idx);
        }

        return result;
    }
}
