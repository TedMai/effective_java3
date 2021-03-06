package chapter5.etc.after;

/**
 * BridgeMethod
 */
public class Node {

	public Object data;

	public Node(Object data) {
		this.data = data;
	}

	public void setData(Object data) {
		System.out.println("Node.setData");
		this.data = data;
	}
}

class MyNode extends Node {
	public MyNode(Integer data) {
		super(data);
	}

	// Bridge method generated by the compiler
	public void setData(Object object) {
		setData((Integer) object);
	}

	public void setData(Integer data) {
		System.out.println("MyNode.setData");
		super.setData(data);
	}

	public static void main(String[] args) {
		MyNode mn = new MyNode(5);
		Node n = mn;
		n.setData(1);
	}
}