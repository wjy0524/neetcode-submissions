class Solution{
    public int maxArea(int[] heights){
        int mxArea = 0;

        int left = 0;
        int right = heights.length - 1;

        while(left < right){
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            int area = width * height;

            mxArea = Math.max(mxArea, area);

            if(heights[left] < heights[right]){
                left++;
            }else{
                right--;
            }
        }

        return mxArea;
    }
}