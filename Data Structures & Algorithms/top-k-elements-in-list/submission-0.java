class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxfreq = 0;
        for(int f : map.values()){
            maxfreq = Math.max(maxfreq, f);
        }

        List<Integer>[] buckets = new ArrayList[maxfreq + 1];
        for(int i=0;i<=maxfreq;i++){
            buckets[i] = new ArrayList<>();
        }
        for(int key : map.keySet()){
            int freq = map.get(key);

            buckets[freq].add(key);

        }

        int[] ans = new int[k];
        int idx = 0;
        for(int i=maxfreq;i>=0;i--){
            for(int j=0;j<buckets[i].size();j++){
                ans[idx++] = buckets[i].get(j);
                if(idx == k) return ans;
            }


        }

        return ans;
    }
}