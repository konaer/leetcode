package Trie;

public class Trie {	
	//初始化为 O(1)，其余操作为 O(|S|)，|S|是每次插入或查询的字符串的长度
	//0(t * n) n是字符集大小 t是所有插入的长度之和
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

	public boolean startsWith(String prefix) {
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
