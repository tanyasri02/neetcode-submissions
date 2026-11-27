class PrefixTree {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;

        for(int i=0;i<word.length();i++){
            int index = word.charAt(i) - 'a';

            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;

        for(int i=0;i<word.length();i++){
            int index = word.charAt(i) - 'a';

            if(curr.children[index] == null)
                return false;

            curr = curr.children[index];
        }

        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for(int i=0;i<prefix.length();i++){
            int index = prefix.charAt(i) - 'a';

            if(curr.children[index] == null)
                return false;

            curr = curr.children[index];
        }
        return true;
    }
}
