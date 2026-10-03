class Solution {
    public int search(int[] nums, int target) {
        //n is the number of num in nums
        int n = nums.length;
        int left = 0;
        int right = n-1;

        while(left<=right){
            int mid = left + (right-left)/ 2;

            if(nums[mid] == target) return mid;

            //왼쪽 정렬 되어있음
            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target <nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                //오른쪽 정렬 되어있음
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
