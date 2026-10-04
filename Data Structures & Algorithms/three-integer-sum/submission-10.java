class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> answer = new ArrayList<>();
        int j, k;

        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++){

            j = i+1;
            k = nums.length-1;
            if(nums[i] > 0) break;
            if(i>0 && nums[i] == nums[i-1]) continue;

            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> oneComb = Arrays.asList(nums[i], nums[j], nums[k]);
                    answer.add(oneComb);
                    j++;
                    k--;
                    while(j<k && nums[k] == nums[k+1]) k--;
                    while(j<k && nums[j] == nums[j-1]) j++;
                }else if(sum>0){
                    k--;
                    while(j<k && nums[k] == nums[k+1]) k--;
                }else{
                    j++;
                    while(j<k && nums[j] == nums[j-1]) j++;
                }
            }
            
        }

        return answer;

    }
}
