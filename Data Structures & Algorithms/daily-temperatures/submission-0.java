class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for(int t=0; t<temperatures.length; t++){
            while (!stack.isEmpty() && temperatures[t] > temperatures[stack.peek()]){
                int idx = stack.pop();
                result[idx] = t - idx;
            }
            stack.push(t);
        }

        return result;
    }
}
