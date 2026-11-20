class MedianFinder {
    PriorityQueue<Integer> lowMaxHeap; 
    PriorityQueue<Integer> upMinHeap;

    public MedianFinder() {
        lowMaxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        upMinHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        lowMaxHeap.offer(num);
        upMinHeap.offer(lowMaxHeap.poll());
        if(upMinHeap.size() > lowMaxHeap.size()){
            lowMaxHeap.offer(upMinHeap.poll());
        }
    }
    
    public double findMedian() {
        if(lowMaxHeap.size() == upMinHeap.size()){
            int fMed = lowMaxHeap.peek();
            int sMed = upMinHeap.peek();
            return (double) (fMed+sMed) / 2;
        }
        return lowMaxHeap.peek();
    }
}
