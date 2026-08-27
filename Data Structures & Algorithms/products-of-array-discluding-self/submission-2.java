class Solution {
    public int[] productExceptSelf(int[] nums) {
        //this is the brute force way: it takes O(n^2)
        //to solve it in O(n), have to use prefix and suffix
        //prefix[i]는 "i번째 원소를 제외한, i보다 왼쪽에 있는 모든 원소들의 곱"
        //suffix[i]는 "i번째 원소를 제외한, i보다 오른쪽에 있는 모든 원소들의 곱"
        
        int[] answer = new int[nums.length];

        //suffix and prefix array만들기
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        prefix[0] = 1;
        suffix[nums.length -1] = 1;

        for(int i=1; i<nums.length; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        for(int j=nums.length-2; j>=0; j--){
            suffix[j] = suffix[j+1] * nums[j+1];
        } 

        for(int idx=0; idx<nums.length; idx++){
            answer[idx] = prefix[idx] * suffix[idx];
        }

        return answer;
       
    }
}  
