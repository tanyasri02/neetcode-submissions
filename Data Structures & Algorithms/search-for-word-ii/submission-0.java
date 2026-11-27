class Solution {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();

        for(String word: words){
            TrieNode curr = root;

            for(int i=0;i<word.length();i++){
                int index = word.charAt(i) - 'a';

                if(curr.children[index] == null)
                    curr.children[index] = new TrieNode();

                curr = curr.children[index];
            }

            curr.word = word;
        }

        int n = board.length;
        int m = board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dfs(board, i, j, root, ans, n, m);
            }
        }

        return ans;
    }

    public void dfs(char[][] board, int i, int j, TrieNode curr, List<String> ans, int n, int m){
        if(i<0 || i>=n || j<0 || j>=m || board[i][j] == '#')
            return;

        int index = board[i][j] - 'a';

        if(curr.children[index] == null)
            return;

        curr = curr.children[index];

        if(curr.word != null){
            ans.add(curr.word);
            curr.word = null;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        dfs(board, i+1, j, curr, ans, n, m);
        dfs(board, i-1, j, curr, ans, n, m);
        dfs(board, i, j+1, curr, ans, n, m);
        dfs(board, i, j-1, curr, ans, n, m);

        board[i][j] = temp;
    }
}
