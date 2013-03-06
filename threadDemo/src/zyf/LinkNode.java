package zyf;
//链表数据结构，每一个对象都持有一个本类对象
public class LinkNode {
	String name;
	LinkNode node;
	public LinkNode(){};
	public String getName() {
		return name;
	}
	public LinkNode getNode() {
		return node;
	}
	public LinkNode(String name) {
		this.name = name;
		this.node = new LinkNode();
	}
	public static void main(String args[]) {
		LinkNode n1 = new LinkNode("08软件1班");
		LinkNode n2 = new LinkNode("08软件2班");
		LinkNode n3 = new LinkNode("08软件3班");
		n1.node = n2;
		n2.node = n3;
		System.out.println(n1.getNode().getNode().getName());
	}
}
