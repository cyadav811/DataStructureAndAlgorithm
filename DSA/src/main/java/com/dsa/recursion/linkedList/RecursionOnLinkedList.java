package com.dsa.recursion.linkedList;

public class RecursionOnLinkedList {
	
	// print all the values in the linkedlist using recursion 
	public static void print(Node head) {
		if(head==null) return;
		System.out.print(head.data+" ");
		print(head.next);
	}
	
	// Reverse a linkedList using Recursion 
	public static Node reverseLinkedList(Node head) {
		if(head==null || head.next==null) {
			return head;
		}
		//When it reaches to the last node due to base condition the last node is returned 
		// and it will be the only node that is returned till the recursion ends....
		
		Node node = reverseLinkedList(head.next);
		head.next.next=head;
         head.next=null;
         return node;   	
	}
	
	
	public static Node revLinkedList(Node head) {
		Node prev = null;
		Node current = head;
		Node next = null;
		
		while(current!=null) {
			next=current.next;
			current.next = prev;
			prev = current;
		    current = next;
		}
		return prev;
		
	}
	
	
	
	// reverse a linked list in a pair of k 
	public static Node reverseInPair(Node head, int k) {
		
		Node prev = null;
		Node current = head;
		Node next = null;
		int count = 0;
		
		while(current!=null && count<k) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		
		if(next!=null) {
			head.next = reverseInPair(next,k);
		}
		
		return prev;
	}
	
	public static void main(String[] args) {
LinkedList lst = new LinkedList();
		
		lst.addFirst(18);
		lst.addFirst(17);
		lst.addFirst(16);
		lst.addFirst(15);
		lst.addFirst(14);
		lst.addFirst(13);
		lst.addFirst(12);
		lst.addFirst(1);
		lst.addLast(19);
		lst.addLast(20);
		lst.addLast(21);
		lst.addLast(22);
		lst.addLast(23);
		lst.addLast(24);
		lst.addLast(25);
		lst.addLast(26);
		
		
		lst.head = reverseInPair(lst.head,3);
		
		print(lst.head);
		//reverseLinkedList(lst.head);
		System.out.println("++++++++++++++++++++++++++");
		lst.head = reverseLinkedList(lst.head);
		print(lst.head);
		
		System.out.println();
		lst.head = revLinkedList(lst.head);
		print(lst.head);
		
		
	}

}
