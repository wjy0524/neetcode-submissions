class Solution {
    public int hammingWeight(int n) {
       int numOf1bits = 0;

        while(n > 0){
            if(n%2 == 1) numOf1bits++;
            n = n >>1;
        }

        return numOf1bits;
    }
}
