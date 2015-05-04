package general;

import java.util.HashMap;
import java.util.List;


/*
 * Given a list of child->parent relationships, build a binary tree out of it. All the element Ids inside the tree are unique.

Example:

Given the following relationships:

Child Parent IsLeft
15 20 true
19 80 true
17 20 false
16 80 false
80 50 false
50 null false
20 50 true


You should return the following tree:
50
/ \
20 80
/ \ / \
15 17 19 16

Function Signature


/**
* Represents a pair relation between one parent node and one child node inside a binary tree
* If the _parent is null, it represents the ROOT node
*/
/*public class Relation {
public Integer _parent;
public Integer _child;
public boolean _isLeft;
}


*//**
* Represents a single Node inside a binary tree
*//*
public class Node {
public Integer _id;
public Node _left;
public Node _right;
}

*//**
* Implement a method to build a tree from a list of parent-child relationships
* And return the root Node of the tree
*//*
public Node buildTree (List<Relation> data)
{
}*/


public class ChildParentRelationTreeBuilding {
	

	/**
	* Represents a pair relation between one parent node and one child node inside a binary tree
	* If the _parent is null, it represents the ROOT node
	*/
	public class Relation {
	public Integer _parent;
	public Integer _child;
	public boolean _isLeft;
	}


	/**
	* Represents a single Node inside a binary tree
	*/
	public class Node {
	public Integer _id;
	public Node _left;
	public Node _right;
		//constructor to initialize the node
		public Node(int data, Node p, Node c){
			this._id = data;
			this._left = p;
			this._right = c;
		}
	}

	/**
	* Implement a method to build a tree from a list of parent-child relationships
	* And return the root Node of the tree
	*/
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	public Node buildTree (List<Relation> data)
	{
		Node root = null;
		for(Relation rl : data){
			Node _tempParent;
			Node _tempChild;
			_tempParent = map.containsKey(rl._parent) ? map.get(rl._parent) : createNode(rl._parent);
			_tempChild = map.containsKey(rl._child) ? map.get(rl._child) : createNode(rl._child);
			if(rl._parent != null){
				if(rl._isLeft)
					_tempParent._left = _tempChild;
				else
					_tempParent._right = _tempChild;
			}
			else{
				root = map.containsKey(rl._child) ? map.get(rl._child) : createNode(rl._child);
			}
		}
		return root;
	}
	
	//creates node if it dosen`t exist
	public Node createNode(int _integer){
		Node _newNode= new Node(_integer, null, null);
		map.put(_integer, _newNode);
		return _newNode; 
	}
	
}
