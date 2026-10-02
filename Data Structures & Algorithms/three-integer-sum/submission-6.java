class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //understanding the problem
        //return all the triplets [nums[i], nums[j], nums[k]] where nums[i] + nums[j] + nums[k] == 0
        //i, j and k are all distinct.
        //the output shouldn't contain any duplicate triplets
        List<List<Integer>> result = new ArrayList<>();
        //sort nums in ascendign order
        Arrays.sort(nums);

        int n = nums.length;

        int j, k;

        for(int i=0; i<n-2; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            j = i+1; //number right after i
            k = n-1; //last number in nums

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> oneComb = new ArrayList<>();
                    oneComb.add(nums[i]);
                    oneComb.add(nums[j]);
                    oneComb.add(nums[k]);
                    result.add(oneComb);
                    j++;
                    k--;
                    //k--가 k랑 같으면 스킵
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

        return result;

    }
}
