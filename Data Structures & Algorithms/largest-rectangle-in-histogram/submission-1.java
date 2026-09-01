class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int n = heights.length;

        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                int height = heights[stack.pop()];
                int leftBound;
                if(!stack.isEmpty()){
                    leftBound = stack.peek();
                }else{
                    leftBound = -1;
                }
                int rightBound = i;
                int width = rightBound - leftBound - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int rightBound = n;
            int leftBound;
            if(!stack.isEmpty()){
                    leftBound = stack.peek();
                }else{
                    leftBound = -1;
                }
            int width = rightBound - leftBound - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}
