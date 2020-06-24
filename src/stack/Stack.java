package stack;

import java.util.EmptyStackException;

public class Stack<T> {

	protected int size = 10 ;

	private int top;

	private Object element[] = null;

	public boolean isEmpty() {
		return (top < 0);
	}

	public Stack(int size) {
		element = new Object[size];
		top = -1;
		this.size= size;
	}
	public Stack() {
		top = -1;
		element = new Object[size];
	}
	
	public int top(){
		return top;
	}

	public boolean push(T t) {
		if (top >= size) {
			System.out.println("Stack Overflow");
			return false;
		} else {
			element[++top] = t;
			return true;
		}
	}

	public T pop() {
		if (top < 0) {
			throw new EmptyStackException();
		} else {
			T t = (T)element[top--];
			return t;
		}
	}
	
	public T peek(){
	
		if (top < 0) {
			throw new EmptyStackException();
		} else {
			T t = (T)element[top];
			return t;
		}
	}	
}
