class Solution {
    public int characterReplacement(String s, int k) {
        
        int left = 0;
        int[] map = new int[26];

        int maxfreq = 0;
        int maxlen = 0;
        for(int right = 0; right < s.length(); right++){

            map[s.charAt(right) -'A']++;
            maxfreq = Math.max(maxfreq, map[s.charAt(right) - 'A']);

            int win = right - left + 1;

            if(k >= win - maxfreq){
                maxlen = Math.max(maxlen, win);
            }else{
                map[s.charAt(left) - 'A']--;
                left++;
            }
        }

        return maxlen;
    }
}
