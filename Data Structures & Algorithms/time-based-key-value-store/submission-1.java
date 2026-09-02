class TimeMap {

    Map<String, List<String>> valueMap;
    Map<String, List<Integer>> timeMap;

    public TimeMap() {
        valueMap = new HashMap<>();
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!valueMap.containsKey(key)){
             valueMap.put(key, new ArrayList<>());
        }
        valueMap.get(key).add(value);

        if(!timeMap.containsKey(key)){
             timeMap.put(key, new ArrayList<>());
        }
        timeMap.get(key).add(timestamp);
    }
    
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) return "";
    
        List<Integer> times = timeMap.get(key);
        List<String> values = valueMap.get(key);
    
        // 여기서 Binary Search로 적절한 인덱스 찾기
        int left = 0, right = times.size() - 1;
        int resultIdx = -1;
    
        while (left <= right) {
            int mid = left + (right - left) / 2;
        
            if (times.get(mid) <= timestamp) {
                resultIdx = mid;  // 조건 만족하는 후보, 기록해두고 더 오른쪽 탐색
                left = mid + 1;
            } else {
            right = mid - 1;
            }
        }
    
        return resultIdx == -1 ? "" : values.get(resultIdx);
    }
}
