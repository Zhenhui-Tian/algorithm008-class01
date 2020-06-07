//Implement a trie with insert, search, and startsWith methods.
//
// Example:
//
//
//Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // returns true
//trie.search("app");     // returns false
//trie.startsWith("app"); // returns true
//trie.insert("app");
//trie.search("app");     // returns true
//
//
// Note:
//
//
// You may assume that all inputs are consist of lowercase letters a-z.
// All inputs are guaranteed to be non-empty strings.
//
// Related Topics Design Trie


//leetcode submit region begin(Prohibit modification and deletion)
class Trie {

    class TreeNode{
        private boolean isEnd = false;
        private final int R = 26;
        TreeNode[] children;

        public TreeNode() {
            children = new TreeNode[R];
        }

        public TreeNode get(char ch) {
            return children[ch - 'a'];
        }

        public void put(char ch, TreeNode node) {
            children[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }

    }

    private TreeNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode temp = root;
        for (int i = 0; i < word.length() ; i++) {
            char ch = word.charAt(i);
            if (temp.get(ch) == null) {
                TreeNode chNode = new TreeNode();
                temp.put(ch, chNode);
            }
            temp = temp.get(ch);
        }
        temp.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode temp = root;
        for (int i = 0; i < word.length() ; i++) {
            char ch = word.charAt(i);
            if (temp.get(ch) == null) {
                return false;
            }
            temp = temp.get(ch);
        }
        // 对于 dad 和 daddy 怎么存的 dad 的isEnd 是什么
        // 按照我这种方法dad 的isEnd 是false
        // 那就和下面的寻找前缀没有区别了
        if(temp.isEnd() == true) {
            return true;
        } else {
            return false;
        }
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode temp = root;
        for (int i = 0; i < prefix.length() ; i++) {
            char ch = prefix.charAt(i);
            if (temp.get(ch) == null) {
                return false;
            }
            temp = temp.get(ch);
        }
        // 对于 dad 和 daddy 怎么存的 dad 的isEnd 是什么
        // 按照我这种方法dad 的isEnd 是false
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
