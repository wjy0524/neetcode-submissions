class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //the array of the number of bananas 
        //piles[i] is the number of bananas at ith pile
        //eating rate(bananas/hour) = k

        //n is the size of piles
        int n = piles.length;
        //m is the maximum numbenr of bananas among piles
        int m = 0;
        //find the maximum number of bananas among piles
        for(int p=0; p<n; p++){
            m = Math.max(m, piles[p]);
        }

        //k can go up from 1 to m
        int leftK= 1;
        int rightK = m;
        int ans = m;

        while(leftK <= rightK){
            int midK = leftK + (rightK - leftK) / 2;
            long totalHours = 0;  // 오버플로우 방지로 long 추천
            for(int p=0; p<n; p++){
                totalHours += (piles[p] + midK - 1) / midK; 
            }
            
            if(totalHours <= h){
                // midK로 충분함 → 더 느려도 되는지 탐색
                ans = midK;
                rightK = midK - 1;
            } else {
                // midK로 부족함 → 더 빨라야 함
                leftK = midK + 1;
            }
        }

        return ans;
    }
}
