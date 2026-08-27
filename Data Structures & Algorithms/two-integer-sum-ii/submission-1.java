class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int idx1 = 0;
        int idx2 = numbers.length-1;

        while(idx1 < idx2){
            if(numbers[idx1] + numbers[idx2] == target){
                return new int[]{idx1+1, idx2+1};
            }else if(numbers[idx1] + numbers[idx2] > target){
                idx2--;
            }else{
                idx1++;
            }
        }

        return new int[]{};
    }
}
