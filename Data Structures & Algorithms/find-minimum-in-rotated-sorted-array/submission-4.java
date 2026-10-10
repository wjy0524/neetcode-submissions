class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        while(left<right){
            int mid = left + (right-left) / 2;
            if(nums[right] < nums[mid]){
                //앞에가 정렬됬다는거지
                left = mid + 1;
            }else{
                //뒤에가 정렬되어있음
                right = mid;
            }

        }
        return nums[left];
    }
}
