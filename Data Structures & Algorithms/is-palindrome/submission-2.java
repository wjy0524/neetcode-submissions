class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for(int c=0; c<s.length(); c++){
            if(Character.isLetterOrDigit(s.charAt(c))){
                sb.append(Character.toLowerCase(s.charAt(c)));
            }
        }

        String str = new String(sb);

        int left = 0;
        int right = str.length()-1;

        while(left < right){
            if(str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}
