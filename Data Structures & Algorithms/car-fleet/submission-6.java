class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        Double[][] cars = new Double[n][2];

        for(int c=0; c<n; c++){
            cars[c][0] = (double) position[c];
            cars[c][1] = (double) speed[c];
        }

        //sort cars in descending order of position
        Arrays.sort(cars, (a, b) -> b[0].compareTo(a[0]));

        //make Stack
        Deque<Double> stack = new ArrayDeque<>();

        Double firstCarTime = (target - cars[0][0]) / cars[0][1];
        stack.push(firstCarTime);

        for(int c=1; c<n; c++){
            Double secCarTime = (target - cars[c][0]) / cars[c][1];
            Double aheadCarTime = stack.peek();
            if(secCarTime > aheadCarTime){
                stack.push(secCarTime);
            }
        }

        return stack.size();

    }
}
