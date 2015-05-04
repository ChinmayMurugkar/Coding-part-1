package general;

/*
 * How do you get the depth of a binary tree? Nodes from the root to a leaf form a path. 
 * Depth of a binary tree is the maximum length of all paths. For example, the depth 
 * of the binary tree in Figure 1 is 4, with the longest path through nodes 1, 2, 5, and 7.
 * 			   1
 * 			  /  \	
 * 			2	  3
 * 		   /  \    \
 * 		  4	   5 	6
 * 			  /
 *           7
 */

public class DepthOfTree {
	
	public int getDepth(TreeNode root,int depth){
	
		if(root == null)
			return 0;
		
		if(root.left==null && root.right!=null)
			 return depth = depth + 1 + getDepth(root.right, depth) + getDepth(root.left,depth);
		else if(root.left != null && root.right != null)
			return depth = depth + 1 + Math.max(getDepth(root.left,depth),getDepth(root.right,depth));
		
		return depth;
	}
	
}
