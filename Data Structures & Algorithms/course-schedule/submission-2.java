class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //I guess you have to make a graph based on prerequisites
        //once you make the graph
        //you can run bfs
        //and check if all courses have been visited

        List<List<Integer>> adjList = new ArrayList<>();
        int[] numOfPrereq = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }


        //fill up the adj List making graph
        for(int[] pair : prerequisites){
            int prereq = pair[1];
            int course = pair[0];
            //put it onto adjList
            adjList.get(prereq).add(course);
            numOfPrereq[course]++;
        }

        Deque<Integer> q = new ArrayDeque<>();

        int completed = 0;

        //once you make graph run bfs
        //처음에 아무 prerequisites이 없는 과목들을 시작점으로 q에 올리고 visited처리 해야함
        for(int i=0; i<numCourses; i++){
            if(numOfPrereq[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int curCourse = q.poll();
            completed++;
            for(int pre=0; pre<adjList.get(curCourse).size(); pre++){
                int nxtCourse = adjList.get(curCourse).get(pre);
                numOfPrereq[nxtCourse]--;
                if(numOfPrereq[nxtCourse] == 0){
                    q.offer(nxtCourse);
                }
            }
        }

        

        return completed == numCourses;

    }
}
