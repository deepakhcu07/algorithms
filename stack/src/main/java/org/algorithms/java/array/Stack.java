package org.algorithms.java.array;

import java.util.EmptyStackException;

/**
 * Array Implementation of Stack
 * @author deepa
 *
 */
public class Stack<T> {
	private T[] items;
	private int size;
	private int capacity;
	
	public Stack() {
		capacity = 10;
		items = (T[]) new Object[capacity];
	}
	
	public Stack(int capacity) {
		this.capacity = capacity;
		items = (T[]) new Object[this.capacity];
	}
	
	public int getLength() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size==0);
	}
	
	
	public void push(T item) {
		if(size>=items.length) {
			resize(size*2);
		}
		items[size] = item;
		size++;
	}
	
	public T pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		T item = items[size-1];
		items[size-1] = null;
		size--;
		if(size>0 && size == (this.items.length/4)) {
			resize(this.items.length/2);
		}
		return item;
	}
	
	private void resize(int newCapacity) {
		T[] temp = (T[])new Object[newCapacity];
		for(int i=0;i<size;i++) {
			temp[i] = items[i];
		}
		items = temp;
		this.capacity=newCapacity;
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
