class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int takeout = 0;

        List<int[]> result = new ArrayList<>();

        for(int[] interval : intervals){
            if(result.isEmpty()){
                result.add(interval);
                continue;
            }
            int[] last = result.get(result.size()-1);
            if(interval[0] < last[1]){
                //겹치는 거임
                takeout++;
            }else{
                result.add(interval);
            }
        }

        return takeout;
    }
}
