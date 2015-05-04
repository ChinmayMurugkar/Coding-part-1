package general;

import java.util.ArrayList;
import java.util.Queue;

/* 
 * First part: 
 * Print all the nodes in the tree level wise
 * Second Part :
 * Return all the nodes in the tree level wise with the level number
 * Thoughts :
 * 1. We will use breadth first search 
 * 2. we have to keep track of levels along with traversing nodes breadth wise
 */

public class TreeLevelTraverse {
	
	public ArrayList<ArrayList> traverseTree(TreeNode root){
		
		//base case
		if(root == null)
			return null;
		if(root.left ==null && root.right == null)
			return null;
		
		ArrayList<ArrayList<TreeNode>> result = getTravTree(root);
		
		return null;
	}
	
	public ArrayList<ArrayList<TreeNode>> getTravTree(TreeNode root){
		
		ArrayList<ArrayList<TreeNode>> result = null;
		ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
		temp.add(1, root);
		int index = 1;
		while(index >=0){
			ArrayList<TreeNode> tempNodes = new ArrayList<TreeNode>();
			for(TreeNode r: temp){
				if(r.left!=null)
					tempNodes.add(r.left);
				if(r.right!=null)
					tempNodes.add(r.right);
			}
			result.add(index++, tempNodes);
		}

		return result;
		
	}
}





















