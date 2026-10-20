class KthLargest {

    PriorityQueue<Integer> pq;
    int K = 0;
    public KthLargest(int k, int[] nums) {
        
        K = k;
        pq = new PriorityQueue<>();

        for(int num : nums){

            pq.offer(num);
            if(pq.size() > k) pq.poll();
        }
    }
    
    public int add(int val) {

        pq.offer(val);

        while(pq.size() > K) pq.poll();

        return pq.peek();
    }
}
