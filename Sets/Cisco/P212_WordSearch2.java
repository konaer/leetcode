package Trie;

public class P212_WordSearch2 {
	// time m * n * 3^l 遍历每个单元格，每个word需要三个方向3^l个路径
	//Space Trie space, 储存l*n ,n个单词，每个l长度
	Set<String> set = new HashSet<>();
    boolean[][] visited;

    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length, n = board[0].length;
        visited = new boolean[m][n];
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, trie, "", i, j);
            }
        }
        return new ArrayList<>(set);
    }

    private void dfs(char[][] board, Trie trie, String s, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }

        if (visited[i][j]) {
            return;
        }

        s += board[i][j];
        if (!trie.isPre(s)) {
            return;
        }

        if (trie.search(s)) {
            set.add(s);
        }

        visited[i][j] = true;
        dfs(board, trie, s, i + 1, j);
        dfs(board, trie, s, i - 1, j);
        dfs(board, trie, s, i, j + 1);
        dfs(board, trie, s, i, j - 1);
        visited[i][j] = false;
    }

    class Trie {
        private Trie[] children;
        private boolean isWord;

        public Trie() {
            children = new Trie[26];
            isWord = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (node.children[i] == null) {
                    node.children[i] = new Trie();
                }
                node = node.children[i];
            }
            node.isWord = true;
        }

        public boolean search(String word) {
            Trie node = this;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (node.children[i] == null) {
                    return false;
                }
                node = node.children[i];
            }
            return node.isWord;
        }

        public boolean isPre(String prefix) {
            Trie node = this;
            for (char c : prefix.toCharArray()) {
                int i = c - 'a';
                if (node.children[i] == null) {
                    return false;
                }
                node = node.children[i];
            }
            return true;
        }
    }
}
