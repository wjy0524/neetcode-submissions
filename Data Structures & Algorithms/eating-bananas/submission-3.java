class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int m = 0;

        for(int p=0; p<n; p++){
            m = Math.max(m, piles[p]);
        }

        int left = 1;
        int right = m;
        int ans = m;

        while(left <= right){
            int mid = left + (right-left) / 2;
            long totalHrs = 0;
            for(int p=0; p<n; p++){
                totalHrs += (piles[p]-1) / mid + 1;
            }

            if(totalHrs <= h){
                // midK로 충분함 → 더 느려도 되는지 탐색
                ans = mid;
                right = mid - 1;
            } else {
                // midK로 부족함 → 더 빨라야 함
                left = mid + 1;
            }


        }

        return ans;
    }
}
