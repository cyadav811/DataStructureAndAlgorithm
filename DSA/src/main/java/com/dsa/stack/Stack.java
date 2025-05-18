package com.dsa.stack;

public class Stack <T> {
	public int maxSize;
	public T [] arr;
	public int top;
	public boolean isEmpty() {
		if(top==-1) return true;
		return false;
	}
	
	public boolean isFull() {
		if(top==maxSize-1) return true;
		return false;
	}
	
	public Stack(int maxSize) {
		this.maxSize = maxSize;
		this.arr = (T[]) new Object[maxSize];
		top =-1;
	}
	
	public boolean push(T data) {
		if(isFull()) return false;
		arr[++top] = data;
		return true;
	}
	
	public T pop() {
		if(isEmpty()) {
			//System.out.print("Stack is empty");
			return null;
		}
	  return arr[top--]	;
	}
	
public T peek() {
	if(isEmpty()) {
		//System.out.print("Stack is empty");
		return null;
	}
	return arr[top]	;
	}

}
