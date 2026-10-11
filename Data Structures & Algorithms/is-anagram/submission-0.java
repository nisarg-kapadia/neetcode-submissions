class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] smap = new int[26];
        int[] tmap = new int[26];

        int n  =s.length();

        for(int i=0;i<n;i++){
            smap[s.charAt(i) - 'a']++;
            tmap[t.charAt(i) - 'a']++;
        }

        for(int i=0;i<26;i++){
            if(smap[i] != tmap[i]) return false;
        }

        return true;
        
        
    }
}
