class KthLargest {

    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        k = k;
        for(int it : nums) {
            minHeap.add(it);

            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.add(val);

        if(minHeap.size() > k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
