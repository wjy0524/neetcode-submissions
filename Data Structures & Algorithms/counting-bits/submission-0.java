class Solution {
    public int[] countBits(int n) {
        int[] bits = new int[n+1];
        int offSet = 1;
        bits[0] = 0;

        for(int num=1; num<n+1; num++){
            if (offSet * 2 == num) {
                offSet = num;      // offset 갱신
            }
            bits[num] = 1 + bits[num - offSet];
        }

        return bits;
    }
}
