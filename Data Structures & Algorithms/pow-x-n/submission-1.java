class Solution {
    public double myPow(double x, int n) {
        long N = n;              // 중요! 아래 설명
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return power(x, N);
    }

    private double power(double x, long n) {
        if (n == 0) return 1.0;           // base case

        double half = power(x, n / 2);    // 절반만 계산
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
