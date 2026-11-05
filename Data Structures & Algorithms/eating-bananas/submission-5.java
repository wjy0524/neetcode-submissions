class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //n is the number of piles
        int n = piles.length;
        //max number of banana in each pile
        int maxB = 0;
        for(int p : piles) maxB = Math.max(maxB, p);

        //two pointers
        //left = possible min of k
        //right = possible max o k
        int left = 1;
        int right = maxB;
        int k = maxB;

        while(left <= right){
            int mid = left + (right-left)/2;
            long totalHrs = 0;
            //calculate the total hours
            for(int p : piles){
                totalHrs += (p - 1) / mid + 1;
            }
            if(totalHrs <= h){
                //that's it 
                k = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return k;
    }
}
