class Solution {
    public void helper(int open, int close, int n, List<String>ans, String curr){
        if(open+close == 2*n){
            ans.add(curr);
            return;
        }

        if(open<n)
            helper(open+1, close, n, ans, curr+"(");

        if(close<open)
            helper(open, close+1, n, ans, curr+")");
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        helper(0, 0, n, ans, "");
        return ans;
    }
}
