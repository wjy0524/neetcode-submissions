class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        //공백 및 non alphanumeric 제거
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<chars.length; i++){
            if(Character.isLetterOrDigit(chars[i])){
                sb.append(chars[i]);
            }
        }
        String filtered = sb.toString().toLowerCase();
        // palindrome 체크
        int left = 0;
        int right = filtered.length() - 1;
        while(left < right){
            if(filtered.charAt(left) != filtered.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
