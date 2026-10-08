class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int mxLongest = 0;

        for(int n : nums){
            numSet.add(n);
        }

        for(int n : numSet){
            if(!numSet.contains(n-1)){
                //출발점인 거임
                int cur = n;
                int longest = 1;
                while(numSet.contains(cur+1)){
                    cur++;
                    longest++;
                }

                mxLongest = Math.max(mxLongest, longest);
            }
        }

        return mxLongest;
    }
}
