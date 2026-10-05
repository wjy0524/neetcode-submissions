class PrefixTree {

    Map<Character, PrefixTree> children;
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
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) return false;   // 길이 없으면?
            node = node.children.get(c);                     // 한 칸 내려가기
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        PrefixTree node = this;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) return false;   // 길이 없으면?
            node = node.children.get(c);                     // 한 칸 내려가기
        }
        return true;

    }
}
