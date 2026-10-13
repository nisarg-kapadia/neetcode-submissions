class Solution {
    public String minWindow(String s, String t) {
        
        if(t.length() > s.length()) return "";

        int[] need = new int[128];
        for(char c : t.toCharArray()){

            need[c]++;
        }

        int required = t.length();
        int minLen = Integer.MAX_VALUE;

        int start = 0;
        int left = 0;
        for(int right=0;right<s.length();right++){

            char ch = s.charAt(right);

            if(need[ch] > 0){
                required--;
            }

            need[ch]--;

            while(required == 0){

                if(minLen > right - left + 1){

                    minLen = right - left + 1;
                    start = left;
                    
                }

                need[s.charAt(left)]++;
                if(need[s.charAt(left)] > 0){
                    required++;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
