class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = numbers.length - 1;
        int[] result = new int[2];
        while(index1 < index2){
            int sum = numbers[index1] + numbers[index2];
            if(sum == target){
                result[0] = index1+1;
                result[1] = index2+1;
                return result;
            }else if(sum < target){
                index1++;
            }else{
                index2--;
            }
        }
        return result;
    }
}
