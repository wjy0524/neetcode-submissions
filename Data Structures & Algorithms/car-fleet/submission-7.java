class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // the number of cars: n
        int n = position.length;
        //have to figure out if each car can catch the front car before it gets to destination
        //for each car, with the cur position and cur speed
        //it will take different time for each car to get to teh target
        //앞에 차량을 뛰어넘을 수는 없으니 일단 position 오름차순으로 정렬 필요
        //근데 position만 바꾸면 speed랑 매칭이 안되네 (speed랑 position이랑 한묶음으로 나타낼 필요 있음)
        //차끼리 한무리가 될지 안될지 비교하는 방법
        //도착까지 걸리는 시간이 더 짧으면 앞차보다 이론상 먼저 도착 (근데 추월은 불가능하니 한무리가 됨)
        double[][] cars = new double[n][2];
        //fill it up
        for(int i=0; i<n; i++){
            cars[i][0] = position[i];
            //걸리는시간 = 남은 거리 / speed
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }
        //앞에 차량을 뛰어넘을 수는 없으니 일단 position 내림차순 정렬 필요
        //(position이 클수록 target이랑 가까운 거니까)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        ArrayDeque<Double> stack = new ArrayDeque<>();  

        for(double[] timeTaken : cars){
            if(stack.isEmpty()){
                stack.push(timeTaken[1]);
            }

            double recentTimeTaken = stack.peek();
            if(recentTimeTaken < timeTaken[1]){
                //더 걸린다는건 합류 못함
                stack.push(timeTaken[1]);
            }
        }

        return stack.size();
    }
}
