class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        //mid1 + mid2 = (nums1.length + nums2.length + 1)/2
        //mid2 = (nums1.length + nums2.length + 1)/2 - mid1;
        int m = nums1.length, n = nums2.length;
        int half = (m + n + 1) / 2;
        int left = 0, right = m;

        while(left <= right){
            int mid1 = left + (right - left) / 2;
            int mid2 = half - mid1;
            int left1  = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int right1 = (mid1 == m) ? Integer.MAX_VALUE : nums1[mid1];
            int left2  = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int right2 = (mid2 == n) ? Integer.MAX_VALUE : nums2[mid2];

    // 2. 올바르게 잘렸나? (교차 비교)
            if (left1 <= right2 && left2 <= right1) {
                if ((m + n) % 2 == 1) return Math.max(left1, left2);//홀수
                return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;                          // 짝수
            }
    // 3. 아니면 이동
            else if (left1 > right2) right = mid1 - 1;   // nums1에서 너무 많이
            else                     left  = mid1 + 1;

        }

        return 0.0;
    }
}
