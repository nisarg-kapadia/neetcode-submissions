class Solution {
    public int characterReplacement(String s, int k) {
        
        int[] map = new int[26];
        int maxLen = 0;

        int left = 0;
        int maxfreq = 0;
        for(int right = 0; right < s.length(); right++){

            map[s.charAt(right) - 'A']++;
            maxfreq = Math.max(maxfreq, map[s.charAt(right) - 'A']);

            int win = right - left + 1;

            if(win - maxfreq > k){

                map[s.charAt(left) - 'A']--;
                maxfreq = Math.max(maxfreq, map[s.charAt(right) - 'A']);
                left++;
                win = right - left + 1;
            }

            maxLen = Math.max(maxLen, right - left + 1);

        }

        return maxLen;
    }
}
