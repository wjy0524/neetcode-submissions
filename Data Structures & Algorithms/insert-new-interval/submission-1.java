class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i=0;
        int n = intervals.length;

        //앞쪽 new interval전에 안 겹치는 곳 
        while(i<n && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        //겹치는 곳 new interval 확장하기
        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        result.add(newInterval);

        while(i<n){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[0][]);
    }
}
