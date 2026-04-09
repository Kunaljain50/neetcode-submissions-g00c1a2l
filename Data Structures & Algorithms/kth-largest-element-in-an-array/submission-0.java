class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int it : nums) {
            minHeap.add(it);

            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
