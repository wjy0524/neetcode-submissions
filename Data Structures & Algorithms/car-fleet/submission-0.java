class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Double[][] cars = new Double[position.length][2];
        
        for(int i=0; i<position.length; i++){
            //casting해줘야해
            cars[i][0] = (double) position[i];
            cars[i][1] = (double) speed[i];
        }

        Arrays.sort(cars, (a, b) -> b[0].compareTo(a[0])); 

        Deque<Double> stack = new ArrayDeque<>();
        Double firstCarTime = (target - cars[0][0]) / cars[0][1];
        stack.push(firstCarTime);

        for(int i=1; i<position.length; i++){
            Double curCarTime = (target - cars[i][0]) / cars[i][1];
            Double aheadCarTime = stack.peek();
            
            if(curCarTime > aheadCarTime) {
                stack.push(curCarTime); 
            }
        }

        return stack.size();
    }
}
