class Solution {
   public int[] plusOne(int[] digits) {
    int n = digits.length;
    
    for (int i = n - 1; i >= 0; i--) {  // 뒤에서부터 순회
        if (digits[i] < 9) {
            digits[i]++;  // 자리올림 없이 끝남
            return digits;  // 바로 반환하고 끝!
        }
        digits[i] = 0;  // 9였다면 0으로 만들고, 자리올림 계속 진행
    }
    
    // 여기까지 왔다는 건, 모든 자리가 9였다는 뜻 (예: [9,9,9] → [1,0,0,0])
    int[] result = new int[n + 1];
    result[0] = 1;
    return result;
}
}
