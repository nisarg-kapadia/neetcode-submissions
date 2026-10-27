class Solution {
    public int countSubstrings(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;

                ans++;
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            int l = i;
            int r = i + 1;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;

                ans++;
            }
        }

        return ans;
    }
}
