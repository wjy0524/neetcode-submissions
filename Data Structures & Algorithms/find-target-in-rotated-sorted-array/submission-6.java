class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target) return mid;

            //왼쪽 파트가 정렬되어있다는거임
            if(nums[left]<=nums[mid]){
                //
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                //오른쪽 파트가 정렬되어있다는거임
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
