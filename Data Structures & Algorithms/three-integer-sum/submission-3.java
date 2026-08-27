class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        //three sum 하는 법
        //이것도 two pointers 이용하는것
        //1 fixed index pointer + left pointer + right pointer
        //일단 숫자 오름차순으로 정렬

        Arrays.sort(nums);
        int left, right;

        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=0; i<nums.length-2; i++){
            //중복은 스킵
            if(i>0 && nums[i] == nums[i-1]) continue;
            left = i+1;
            right = nums.length -1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[left]);
                    ans.add(nums[right]);
                    result.add(ans);
                    left++;
                    right--;
                    // 여기 추가! left가 직전 값과 같으면 건너뛰기
                    while(left < right && nums[left] == nums[left-1]) left++;
                    // right가 직전 값과 같으면 건너뛰기
                    while(left < right && nums[right] == nums[right+1]) right--;
                }else if(sum > 0){
                    right--;
                    while(left < right && nums[right] == nums[right+1]) right--;
                }else{
                    left++;
                    while(left < right && nums[left] == nums[left-1]) left++;
                }
            }
        }

        return result;
    }
}
