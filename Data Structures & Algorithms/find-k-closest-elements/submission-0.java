class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> ans = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->{

            if(a[1] != b[1]) return Integer.compare(b[1], a[1]);
            return Integer.compare(b[0], a[0]);
        });

        
        for(int i = 0; i < arr.length; i++){

            pq.offer(new int[]{arr[i], Math.abs(arr[i] - x)});

            if(pq.size() > k){
                pq.poll();
            }
        }

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            ans.add(cur[0]);
        }

        Collections.sort(ans);

        return ans;
        
    }
}