class Solution {
    public List<String> generateParenthesis(int n) {
        int open = n;
        int close = n;
        List<String> ans = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        fun(open, close, sb, ans);

        return ans;
    }

    public void fun(int open, int close, StringBuilder sb, List<String> ans) {
        if (open == 0 && close == 0) {
            String res = sb.toString();
            ans.add(res);
            return;
        }

        if (close < open)
            return;

        if (open > 0) {
            sb.append('(');
            fun(open - 1, close, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close > 0) {
            sb.append(')');
            fun(open, close - 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
