package Trie;

public class WordDictionary {
	//time n, word长度
	//space kn*26
	private TrieNode root;
	
	public WordDictionary() {
		root = new TrieNode();
    }
    
    public void addWord(String word) {
    	TrieNode node = this.root;
    	for (char c : word.toCharArray()) {
    		int i = c - 'a';
    		if (node.children[i] == null) {
    			node.children[i] = new TrieNode();
    		}
    		node = node.children[i];
    	}
    	node.isWord = true;
    }
    
    public boolean search(String word) {
    	return dfs(word, 0, this.root);
    }
    
    private boolean dfs(String word, int index, TrieNode node) {
    	if (index == word.length()) {
    		return node.isWord;
    	}
    	
    	char c = word.charAt(index);
    	if (c != '.') {
    		if (node.children[c - 'a'] == null) {
    			return false;
    		} else {
    			return dfs(word, index + 1, node.children[c - 'a']);
    		}
    	} else {
    		for (int i = 0; i < 26; i++) {
    			if (node.children[i] != null && dfs(word, index + 1, node.children[i])) {
    				return true;
    			}
    		}
    		return false;
    	}	
    }
    
    private class TrieNode {
    	private TrieNode[] children = new TrieNode[26];
    	private boolean isWord = false;
    }   
}
