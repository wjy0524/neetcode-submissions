class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        //[n][0] == position of nth char
        //[n][1] == speed of nth car
        Double[][] cars = new Double[n][2];

        for(int i=0; i<n; i++){
            cars[i][0] = (double) position[i];
            cars[i][1] = (double) speed[i];
        }

        //position을 내림차순으로 정렬
        Arrays.sort(cars, (a,b) -> b[0].compareTo(a[0]));

        Deque<Double> stack = new ArrayDeque<>();
        Double firstCarTime = (target - cars[0][0]) / cars[0][1];
        stack.push(firstCarTime);

        for(int i=1; i<n; i++){
            Double curCarTime = (target - cars[i][0]) / cars[i][1];
            Double aheadCarTime = stack.peek();
            
            //더 오래걸린다는거는 앞선 자동차랑 마주칠 일이 없다
            if(curCarTime > aheadCarTime) {
                stack.push(curCarTime); 
            }
        }

        return stack.size();
        
    }
}
