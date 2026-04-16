class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int it : stones) {
            minHeap.add(it);
        }

        while(minHeap.size() > 1) {
            int x = minHeap.poll();
            int y = minHeap.poll();
            System.out.println(x);
            System.out.println(y);

            minHeap.add(Math.abs(y - x));
        }

        return minHeap.peek();
    }
}
