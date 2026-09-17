class Solution {
    List<Integer> nums = new ArrayList<>();
    public boolean isHappy(int n) {
        if(n == 1){
            return true;
        }
        if(nums.contains(n)){
            return false;
        }

        String num = Integer.toString(n);
        int sum = 0;
        for(int i=0; i<num.length(); i++){
            int digit = num.charAt(i) - '0';
            sum += digit * digit;
        }
        nums.add(n);
        return isHappy(sum);
    }
}
