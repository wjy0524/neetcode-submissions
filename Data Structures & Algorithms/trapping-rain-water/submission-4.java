class Solution {
    public int trap(int[] height) {
        //각각의 위치를 따로 계산해서 더해야한다
        //각각의 위치에서의 넓이
        //넓이: min(왼쪽 기둥중 가장 높은 것, 오른쪽 기둥중 가장 높은것) - 현재 위치의 높이
        int maxArea = 0;
        //prefix 자신의 왼쪽 칸중 가장 높은 위치의 높이
        //suffix 자신의 오른쪽 칸중 가장 높은 위치의 높이
        int[] prefix = new int[height.length];
        int[] suffix = new int[height.length];

        prefix[0] = 0;
        suffix[height.length-1] = 0;


        for(int i=1; i<height.length; i++){
            prefix[i] = Math.max(prefix[i-1], height[i-1]);
        }

        for(int j=height.length-2; j>=0; j--){
            suffix[j] = Math.max(suffix[j+1], height[j+1]);
        }

        for(int idx=0; idx<height.length; idx++){
            int water = Math.min(prefix[idx], suffix[idx]) - height[idx];
            if(water > 0){  // 음수면 그냥 0으로 취급 (물 없음)
                maxArea += water;
            }
        }

        return maxArea;


    }
}
