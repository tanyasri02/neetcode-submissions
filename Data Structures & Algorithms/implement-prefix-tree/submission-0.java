class PrefixTree {
    HashMap<String, Integer> trie;
    HashMap<String, Integer> patterns;

    public PrefixTree() {
        trie = new HashMap<>();
        patterns = new HashMap<>();
    }

    public void insert(String word) {
        trie.put(word, trie.getOrDefault(word, 0)+ 1);

        String s = "";
        for(char ch : word.toCharArray()){
            s += ch;
            patterns.put(s, patterns.getOrDefault(ch, 0)+ 1);
        }
    }

    public boolean search(String word) {
        return trie.getOrDefault(word, 0) > 0 ? true : false;
    }

    public boolean startsWith(String prefix) {
        return patterns.getOrDefault(prefix, 0) > 0 ? true : false;
    }
}
