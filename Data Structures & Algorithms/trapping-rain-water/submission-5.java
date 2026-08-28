class Solution {
    public int trap(int[] height) {
        //각각 칸을 따로 구하걸임
        //prefix: 자기 자신 위치 왼쪽으로 가장 큰 높이
        //suffix: 자기 자신 위치 오른쪽으로 가장 큰 높이
        //그 칸의 water = min(prefix[i], suffix[i]) - 현재 높이
        int[] prefix = new int[height.length];
        int[] suffix = new int[height.length];

        prefix[0] = 0;
        suffix[height.length-1] = 0;

        //prefix 채워넣기
        for(int i=1; i<height.length; i++){
            prefix[i] = Math.max(prefix[i-1], height[i-1]);
        }

        for(int j=height.length-2; j>=0; j--){
            suffix[j] = Math.max(suffix[j+1], height[j+1]);
        }
        int totalWater = 0;
        for(int h=0; h<height.length; h++){
            int curWater = (Math.min(prefix[h], suffix[h]) - height[h]);
            if(curWater > 0) totalWater += curWater;
        }

        return totalWater;
    }
}
