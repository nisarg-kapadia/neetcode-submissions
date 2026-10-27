class Solution {
    public String longestPalindrome(String s) {
        
        int maxlen = 0;
        String ans = "";

        for(int i=0;i<s.length();i++){

            int l = i;
            int r = i;

            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            
            l--;r++;
            
            
        }

            if(r - l + 1 > maxlen){
                maxlen = r - l + 1;
                ans = s.substring(l + 1, r);
            }
        }

        for(int i=0;i<s.length() - 1; i++){

            int l = i;
            int r = i + 1;

            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            
            l--;r++;
            
            
        }

            if(r - l + 1 > maxlen){
                maxlen = r - l + 1;
                ans = s.substring(l + 1, r);
            }
            
        }

        return ans;
    }
}
