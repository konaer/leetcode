package bfs;

import java.util.*;

//Definition for a binary tree node.
//public class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//
//	TreeNode(int x) {
//		val = x;
//	}
//}

public class P297_Serialize_and_Deserialize_Binary_Tree {
	
	// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			if (root == null) {
				return "[]";
			}
			
			List<TreeNode> nodes = new ArrayList<>();
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				nodes.add(node);
				
				if (node == null) {
					continue;
				} else {
					queue.offer(node.left);
					queue.offer(node.right);
				}			
			}
			
			while (nodes.get(nodes.size() - 1) == null) {
				nodes.remove(nodes.size() - 1);
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			sb.append(nodes.get(0).val);
			for (int i = 1; i < nodes.size(); i++) {
				if (nodes.get(i) == null) {
					sb.append(",null");
				} else {
					sb.append(",");
					sb.append(nodes.get(i).val);
				}
			}
			sb.append("]");
			return sb.toString();		
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
	        if (data.equals("[]")) {
	        	return null;
	        }
	        
	        String[] nodes = data.substring(1, data.length() - 1).split(",");
	        int pointer = 0;
	        TreeNode root = findNode(nodes, pointer);
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.offer(root);
	        
	        while(!queue.isEmpty()) {
	        	TreeNode node = queue.poll();
	        	
	        	pointer++;
	        	if (pointer == nodes.length) {
	        		break;
	        	}
	        	node.left = findNode(nodes, pointer);
	        	if (node.left != null) {
	        		queue.offer(node.left);
	        	}
	        	
	        	pointer++;
	        	if (pointer == nodes.length) {
	        		break;
	        	}
	        	node.right = findNode(nodes, pointer);
	        	if (node.right != null) {
	        		queue.offer(node.right);
	        	}
	        }
	        return root;
	    }
		
		private TreeNode findNode(String[] nodes, int pointer) {
			if (nodes[pointer].equals("null")) {
				return null;
			} else {
				return new TreeNode(Integer.parseInt(nodes[pointer]));
			} 
		}
		
		
		
		//dfs写法
		// Encodes a tree to a single string.
	    public String serialize(TreeNode root) {
	    	StringBuilder sb = new StringBuilder();
	    	dfs(root, sb);
	    	return sb.toString();
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
	        return dfs2(queue);
	    }
	    
	    private void dfs(TreeNode root, StringBuilder sb) {
	    	if (root == null) {
	    		sb.append("#,");
	    		return;
	    	}
	    	sb.append(root.val).append(",");
	    	dfs(root.left, sb);
	    	dfs(root.right, sb);
	    }
	    
	    private TreeNode dfs2(Queue<String> queue) {
	    	String node = queue.poll();
	        if (node.equals("#")) {
	        	return null;
	        }
	        TreeNode root = new TreeNode(Integer.parseInt(node));
	        root.left = dfs2(queue);
	        root.right = dfs2(queue);
	        return root;
	    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
