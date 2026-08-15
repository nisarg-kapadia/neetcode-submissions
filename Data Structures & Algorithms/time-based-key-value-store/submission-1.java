class TimeMap {

    HashMap<String, List<Node>> map;
    public TimeMap() {
        map  = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Node(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        
        if(!map.containsKey(key)) return "";

        List<Node> lst = new ArrayList<>(map.get(key));

        if(lst.isEmpty()) return "";
        
        int left = 0;
        int right = lst.size() - 1;
        int ans = -1;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(lst.get(mid).time <= timestamp){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        if(ans != -1) return lst.get(ans).value;

        return "";

    }

    public class Node{
        String value;
        int time;

        public Node(String value, int time){
            this.value = value;
            this.time = time;
        }

    }
}
