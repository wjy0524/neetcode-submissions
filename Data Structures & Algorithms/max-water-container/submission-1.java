class Solution {
    public int maxArea(int[] heights){
        int mxArea = 0;
        //set the left and right pointer
        //left starts from 0 and right starts from heights.length -1
        int left = 0;
        int right = heights.length -1;
        //while left < right
        while(left <right){
            //have to find the max area so let's calculate curr area with left and right
            int area = (right - left)  * Math.min(heights[left], heights[right]);
            //update mxArea
            if(area > mxArea) mxArea = area;
            //heights[left], heights[right] 이 둘중 더 낮은 곳의 index를 한칸 옮긴다
            if(heights[left] <= heights[right]){
                left++;
            }else{
                right--;
            }

        }

        return mxArea;
        
    }
}
