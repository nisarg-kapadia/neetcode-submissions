class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int n = position.length;
        Pair[] cars = new Pair[n];
        for(int i=0;i<n;i++){
            cars[i] = new Pair(position[i], speed[i]);
        }

        Arrays.sort(cars, (a, b) -> a.pos - b.pos);

        Stack<Double> st = new Stack<>();

        for(int i=n-1;i>=0;i--){

            double time = (double)(target - cars[i].pos)/cars[i].vel;

            if(st.isEmpty() || time > st.peek()){
                st.push(time);
            }

            
        }

        return st.size();
    }

    class Pair{

        int pos;
        int vel;

        public Pair(int pos, int vel){

            this.pos = pos;
            this.vel = vel;
        }
    }
}
