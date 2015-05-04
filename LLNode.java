package general;

public class LLNode {
	int data;
	LLNode next;
	LLNode prev;
	
	public LLNode(){
		data = 0;
		this.next = null;
	}
	
	public LLNode(int d, LLNode n){
		this.data = d;
		this.next = n;
	}
	
	public LLNode(int d){
		this.data = d;
		this.next = null;
	}
	
	public Integer getData(){return this.data;}
	
	public LLNode getnext(){return this.next;}
}
