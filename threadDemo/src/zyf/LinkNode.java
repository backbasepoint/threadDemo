package zyf;
//�������ݽṹ��ÿһ�����󶼳���һ���������
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
		LinkNode n1 = new LinkNode("08���1��");
		LinkNode n2 = new LinkNode("08���2��");
		LinkNode n3 = new LinkNode("08���3��");
		n1.node = n2;
		n2.node = n3;
		System.out.println(n1.getNode().getNode().getName());
	}
}
