class PrefixTree {
    HashMap<Character, PrefixTree> children;
    boolean isEnd;

    public PrefixTree() {
        children = new HashMap<>();
        isEnd = false;
    }

    public void insert(String word) {
        PrefixTree node = this;
        for(char c : word.toCharArray()){
            node.children.putIfAbsent(c, new PrefixTree());
            node = node.children.get(c);
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        PrefixTree node = this;
        for(char c : word.toCharArray()){
            if(!node.children.containsKey(c)) return false;
            node = node.children.get(c);
        }

        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        PrefixTree node = this;
        for(char c : prefix.toCharArray()){
            if(!node.children.containsKey(c)) return false;
            node = node.children.get(c);
        }

        return true;
    }
}
