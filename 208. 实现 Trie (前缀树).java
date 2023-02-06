class Trie {

    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie cur = this;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] != null) {
                cur = cur.children[c - 'a'];
                continue;
            }
            cur.children[c - 'a'] = new Trie();
            cur = cur.children[c - 'a'];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    public Trie searchPrefix(String prefix) {
        Trie cur = this;
        for (int i = 0; i < prefix.length(); ++i) {
            char c = prefix.charAt(i);
            if (cur.children[c - 'a'] == null) {
                return null;
            }
            cur = cur.children[c - 'a'];
        }
        return cur;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */