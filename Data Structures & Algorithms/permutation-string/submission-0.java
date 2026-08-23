class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int n = s1.length();
        int[] s1map = new int[26];

        for(char ch : s1.toCharArray()){
            s1map[ch - 'a']++;
        }

        int[] s2map = new int[26];
        int left = 0;

        for(int right = 0; right < s2.length(); right++){

            s2map[s2.charAt(right) - 'a']++;

            while(right - left + 1 > n){

                s2map[s2.charAt(left) - 'a']--;
                left++;
                
            }

            if(right - left + 1 == n){
                if(Arrays.equals(s1map, s2map)) return true;
            }
        }

        return false;

        
    }
}
