class Solution {
    public boolean isPalindrome(String s) {
        
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){

            if(Character.isLetter(c)){
                sb.append(Character.toLowerCase(c));
            }

            if(Character.isDigit(c)){
                sb.append(c);
            }
            
        }

        StringBuilder rev = new StringBuilder(sb);
        System.out.println(sb);
        rev.reverse();
        System.out.println(rev);

        return sb.toString().equals(rev.toString());
    }
}
