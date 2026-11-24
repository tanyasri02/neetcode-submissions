class Solution {
    public void solve(char[][] str, List<String> ans, String digits, int pos, String curr) {
        if (pos == digits.length()) {
            if (!curr.equals(""))
                ans.add(curr);
            return;
        }

        int temp = digits.charAt(pos) - '0';

        for (int i = 0; i < str[temp].length; i++) {
            curr = curr + str[temp][i];
            solve(str, ans, digits, pos + 1, curr);
            curr = curr.substring(0, curr.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        char[][] str = {
            {}, {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
        };

        solve(str, ans, digits, 0, "");
        return ans;
    }
}