package com.dsa.recursion.linkedList;

public class LinkedList {
	
	public Node head;
	public Node tail;
	
	public  void addFirst(int data) {
		Node node = new Node(data);
		if(this.head==null) {
			this.head = this.tail = node; 
		}
		else {
			node.next = this.head;
			head = node;
		}
	}
	
	public  void addLast(int data) {
		Node node = new Node(data);
		if(this.head==null) {
			this.head = this.tail = node; 
		}
		else {
			tail.next = node;
			tail = node;
		}
	}

	
	
	public void print(Node head) {
		 Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp  = temp.next;
		}
	}
}

class Node{
	public int data;
	public Node next;
	public Node(int data) {
		this.data = data;
	}
}