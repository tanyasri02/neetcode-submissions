class WordDictionary {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for(int i=0;i<word.length();i++){
            int index = word.charAt(i) - 'a';

            if(curr.children[index] == null)
                curr.children[index] = new TrieNode();

            curr = curr.children[index];
        }

        curr.isEnd = true;
    }

    public boolean dfs(String word, TrieNode curr, int i){
        if(word.length() == i)
            return curr.isEnd;

        char ch = word.charAt(i);

        if(ch == '.'){
            for(int j=0;j<26;j++){
                if(curr.children[j] != null){
                    if(dfs(word, curr.children[j], i+1))
                        return true;
                }
            }
            return false;
        }

        int index = ch - 'a';

        if(curr.children[index] == null)
            return false;

        return dfs(word, curr.children[index], i+1);
    }

    public boolean search(String word) {
        TrieNode curr = root;
        return dfs(word, curr, 0);
    }
}
