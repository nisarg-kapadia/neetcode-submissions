class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {

            int d1 = a[0]*a[0] + a[1]*a[1];

            int d2 = b[0]*b[0] + b[1]*b[1];

            return Integer.compare(d2, d1);
        });

        for(int[] p : points){

            pq.offer(p);

            if(pq.size() > k) pq.poll();
        }

        int[][] ans = new int[pq.size()][2];

        int idx = 0;

        while(!pq.isEmpty()){

            ans[idx++] = pq.poll();
        }

        return ans;

    }
}
