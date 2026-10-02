class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();

        int[] ans = new int[temperatures.length];

        //iterate through each day
        for(int day=0; day<temperatures.length; day++){
            while(!stack.isEmpty() && temperatures[day] > temperatures[stack.peek()]){
                int prevDay = stack.pop();
                ans[prevDay] = day - prevDay;
            }

            stack.push(day);
        }

        return ans;
    }
}
