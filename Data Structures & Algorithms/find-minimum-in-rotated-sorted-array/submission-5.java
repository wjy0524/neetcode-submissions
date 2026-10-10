class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;

        while(l<r){
            int m = l + (r-l) / 2;
            if(nums[r] < nums[m]){
                //앞에가 정렬됬다는거지
                l = m + 1;
            }else{
                //뒤에가 정렬되어있음
                r = m;
            }

        }
        return nums[l];
    }
}
