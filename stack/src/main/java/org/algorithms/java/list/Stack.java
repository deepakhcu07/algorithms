package org.algorithms.java.list;

import java.util.EmptyStackException;

public class Stack<T> {
	
	private Node<T> head;
	private int size;
	
	public int getLength() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public void push(T data) {
		if(isEmpty()) {
			head = new Node<T>(data);
		}else {
			Node<T> temp = new Node<>(data, head);
			head = temp;
		}
		size++;
		return;
	}
	
	public T pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		T data = head.data;
		head=head.next;
		size--;
		return data;
	}
	
	public static class Node<T>{
		T data;
		Node<T> next;
		
		Node(T data){
			this.data = data;
			this.next = null;
		}
		
		Node (T data, Node<T> next){
			this.data = data;
			this.next = next;
		}
	}
	
	
	public static void main(String []args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(5);
		stack.push(4);
		stack.push(3);
		
		System.out.println("Size of the stack: " + stack.getLength());
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println("Size of the stack: " + stack.getLength());
	}
}
