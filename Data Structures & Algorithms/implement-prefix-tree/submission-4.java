class PrefixTree {
    PrefixTree[] children;
    boolean isEnd;
    public PrefixTree() {
        children = new PrefixTree[26]; 
        isEnd = false;
    }

    public void insert(String word) {
        PrefixTree node = this;
        for(char c : word.toCharArray()){
            if(node.children[c - 'a'] == null){
                node.children[c - 'a'] = new PrefixTree();
            }
            node = node.children[c-'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        PrefixTree node = this;
        for(char c : word.toCharArray()){
            if(node.children[c-'a'] == null) return false;
            node = node.children[c-'a'];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        PrefixTree node = this;
        for(char c : prefix.toCharArray()){
            if(node.children[c-'a'] == null) return false;
            node = node.children[c-'a'];
        }
        return true;

    }
}
