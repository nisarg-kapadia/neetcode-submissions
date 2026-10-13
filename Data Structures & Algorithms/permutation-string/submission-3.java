class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        Set<Character> set = new HashSet<>();
        for(char c : s1.toCharArray()){
            set.add(c);
        }
        int n = s1.length();

        for(int i=0;i<=s2.length() - n;i++){

            if(set.contains(s2.charAt(i))){
                if(check(s1, s2.substring(i, i + n))) return true;

            }
        }

        return false;

        
    }

    public boolean check(String s1, String s2){

        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);
        char[] s2Arr = s2.toCharArray();
        Arrays.sort(s2Arr);

        return Arrays.equals(s1Arr, s2Arr);
    }
}
