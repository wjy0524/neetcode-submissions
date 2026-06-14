class Solution {
    public int trap(int[] height) {
        int maxArea = 0;
        //각 위치에서 고일 수 있는 물의 양 = min(왼쪽 최대높이, 오른쪽 최대높이) - 현재높이
        //물의 양 = min(prefix[i], suffix[i]) - height[i]
        //then have to caculate prefix and suffix first
        int n = height.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = height[0];
        for(int i=1; i<n; i++){
            prefix[i] = Math.max(prefix[i-1], height[i]);
        }

        suffix[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--){
            suffix[i] = Math.max(suffix[i+1], height[i]);
        }

        for(int i=0; i<n; i++){
            int area = Math.min(prefix[i], suffix[i]) - height[i];
            if(area>=0) maxArea += area;
        }

        return maxArea;
    }
}
