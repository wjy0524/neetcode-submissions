
class Twitter {
    private int time = 0;
    private Map<Integer, List<int[]>> tweetMap = new HashMap<>();   // userId -> [[time, tweetId], ...]
    private Map<Integer, Set<Integer>> followMap = new HashMap<>(); // userId -> followeeIds

    public Twitter() {}

    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>())
                .add(new int[]{time++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        // heap entry: {time, tweetId, userId, nextIndex}; newest first
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        Set<Integer> users = new HashSet<>(followMap.getOrDefault(userId, new HashSet<>()));
        users.add(userId);

        for (int uid : users) {
            List<int[]> tweets = tweetMap.get(uid);
            if (tweets != null && !tweets.isEmpty()) {
                int idx = tweets.size() - 1;
                int[] t = tweets.get(idx);
                maxHeap.offer(new int[]{t[0], t[1], uid, idx - 1});
            }
        }

        while (!maxHeap.isEmpty() && res.size() < 10) {
            int[] cur = maxHeap.poll();
            res.add(cur[1]);
            int uid = cur[2], idx = cur[3];
            if (idx >= 0) {
                int[] t = tweetMap.get(uid).get(idx);
                maxHeap.offer(new int[]{t[0], t[1], uid, idx - 1});
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> s = followMap.get(followerId);
        if (s != null) s.remove(followeeId);  // HashSet.remove doesn't throw if missing
    }
}