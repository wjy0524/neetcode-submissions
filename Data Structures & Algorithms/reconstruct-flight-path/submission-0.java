class Solution {
    Map<String, PriorityQueue<String>> flightMap = new HashMap<>();
    LinkedList<String> res = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        //in this problem, instead of typical numerical weight
        for(List<String> tick : tickets){
            //tick.get(0) = 출발지
            //tick.get(1) = 도착지
            //없다면 pq 새로 만들고 있다면 기존 pq에 도착지 넣기
            flightMap.computeIfAbsent(tick.get(0), x -> new PriorityQueue<>()).offer(tick.get(1));
        }
        dfs("JFK");
        return res;    
    }

    void dfs(String start){
        PriorityQueue<String> dests = flightMap.get(start);
        while (dests != null && !dests.isEmpty()) {
            dfs(dests.poll());          // 사전순으로 가장 작은 곳부터, 티켓 사용
        }
        res.addFirst(start);
    }
}
