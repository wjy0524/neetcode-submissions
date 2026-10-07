class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //understand the problem
        //그냥 드는 직관
        //intervals end를 sort한다음에 앞에서 부터 겹치면 바로 빼는 식으로 하면 되지 않나?
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int ans = 0;

        List<int[]> result = new ArrayList<>();

        for(int[] interval : intervals){
            if(result.isEmpty()){
                result.add(interval);
                continue;
            }
            int[] last = result.get(result.size()-1);
            if(last[1] <= interval[0]){
                result.add(interval);
            }else{
                ans++;
            }
        }

        return ans;
    }
}
