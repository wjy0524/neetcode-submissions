class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        // n is the size of intervals
        // m is the size of queries
        int n = intervals.length;
        int m = queries.length;

        int[] answer = new int[m];

        //intervals 시작점 기준 정렬
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        //원래 query 순서대로 return 해야하니까 원래 index 저장 with 쿼리값
        int[][] qs = new int[m][2];
        for (int j = 0; j < m; j++) {
            qs[j] = new int[]{queries[j], j};    // {쿼리 값, 원래 인덱스}
        }

        Arrays.sort(qs, (a, b) -> Integer.compare(a[0], b[0]));

        //(구간 길이, 구간 끝)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int i=0;

        for(int[] q : qs){
            int val = q[0];
            int ogIdx = q[1];

            //가능성 있는 시작점이 val보다 낮은 애들 pq.에 다 넣기
            while(i<n &&  intervals[i][0] <= val){
                int len = intervals[i][1] - intervals[i][0] + 1;
                pq.offer(new int[]{len, intervals[i][1]});
                i++;
            }

            //heap 맨위 가 value 포함 못하면 poll
            while(!pq.isEmpty() && pq.peek()[1] < val) pq.poll();

            answer[ogIdx] = pq.isEmpty() ? -1 : pq.peek()[0];

        }

        return answer;

    }
}
