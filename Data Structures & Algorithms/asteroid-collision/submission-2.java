class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();

        for(int a : asteroids){

            boolean alive = true;

            while(!st.isEmpty() && (st.peek() > 0 && a < 0)){

                int b = st.peek();

                if(-a > b){
                    st.pop();
                }else if(-a == b){
                    st.pop();
                    alive = false;
                    break;

                }else{
                    alive = false;
                    break;
                }
            }

            if(alive){
                st.push(a);
            }
        }

        int n = st.size();

        int[] ans = new int[n];
        for(int i=n-1;i>=0;i--){

            ans[i] = st.pop();
        }    

        return ans;
    }
}