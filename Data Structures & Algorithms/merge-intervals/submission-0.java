class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals[0].length;
        int m = intervals.length;

        List<int[]> result = new ArrayList<>();

        //sort it 시작점(기준) asending
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for(int[] interval : intervals){
            if(result.isEmpty()){
                result.add(interval);
                continue;
            }
            int[] last = result.get(result.size()-1);
            int curStart = interval[0];
            int lastEnd = last[1];
            if(curStart <= lastEnd){
                last[1] = Math.max(lastEnd, interval[1]);
            }else{
                result.add(interval);
            }
        }

        return result.toArray(new int[0][]);
    }
}
