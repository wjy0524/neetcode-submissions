class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int rightBound = i;
                int leftBound = stack.isEmpty() ? -1 : stack.peek();
                int width = rightBound - leftBound - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        // for문 끝나고 남은 것들 처리
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int rightBound = n;
            int leftBound = stack.isEmpty() ? -1 : stack.peek();
            int width = rightBound - leftBound - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;



    }
}
