package general;

/*
 * Please implement a function which returns mirror of a binary tree.
 * Thoughts:
 * We would use pre-order to go through each of the node and swao the left and right nodes
 */


public class MirrorBinaryTree {

	public void MirrorBST(TreeNode root){
		
		//if reached lasst node
		if(root == null)
			return;
		
			swap(root,root.left,root.right);
		
			if(root.left!=null)
				MirrorBST(root.left);
			
			if(root.right!=null)
				MirrorBST(root.right);

	}
	
	public void swap(TreeNode root,TreeNode left, TreeNode right){
		TreeNode temp;
		temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

}
