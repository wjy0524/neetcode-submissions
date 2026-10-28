class Solution {
    public boolean checkValidString(String s) {
        //possible minimum number of (
        //*를 )로 쓰는 경우
        int low = 0;
        //possible maximum number of (
        //*를 (로 쓰는 경우
        int high = 0;

        for(char c : s.toCharArray()){
            if(c == '('){
                low++;
                high++;
            }else if(c == ')'){
                low--;
                high--;
            }else if(c == '*'){
                low--;
                high++;
            }
            if(high<0) return false;
            if(low<0) low = 0;
        }

        return low == 0;
    }
}