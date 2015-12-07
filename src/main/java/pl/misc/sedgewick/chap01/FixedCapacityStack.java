package pl.misc.sedgewick.chap01;

import java.util.Iterator;

public class FixedCapacityStack<T> implements Iterable<T> {
	private T[] a; // stack entries
	private int N = -1; // size

	@SuppressWarnings("unchecked")
	public FixedCapacityStack(int cap) {
		a = (T[]) new Object[cap];
	}

	public boolean isEmpty() {
		System.out.print("IsEmpty? : ");
		return N == -1;
	}

	public int size() {
		return N + 1;
	}

	public void push(T item) {
		if (N == a.length - 1) {
			resize();
		}
		a[++N] = item;
		System.out.println(a.length);
	}

	public T pop() {
		if (N == -1) {
			System.out.print("UnderFlow!!! : ");
			return null;
		}
		return a[N--];
	}

	private void resize() {
		int newLength = 2 * a.length;
		@SuppressWarnings("unchecked")
		T temp[] = (T[]) new Object[newLength];
		for (int i = 0; i < a.length; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < N + 1; i++) {
			s += a[i] + " ";
		}
		return s;
	}

	@SuppressWarnings("unused")
	public static void main(String... args) {
		/*FixedCapacityStack<Integer> stack = new FixedCapacityStack<Integer>(3);
		stack.push(45);
		stack.push(94);
		stack.push(7);
		stack.push(7);
		System.out.println(stack.isEmpty());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
		System.out.println(stack);
		stack.push(45);
		stack.push(94);
		stack.push(7);
		System.out.println(stack.isEmpty());
		System.out.println(stack);*/
		
		FixedCapacityStack<String> stack = new FixedCapacityStack<String>(3);
		
	}

	@Override
	public Iterator<T> iterator() {
		return new CapacityStackIterator<T>();
	}

	private class CapacityStackIterator<E> implements Iterator<E> {

		int i = N;

		@Override
		public boolean hasNext() {
			return i >= 0;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			return (E) a[i--];
		}

		@Override
		@Deprecated
		public void remove() {
			throw new UnsupportedOperationException("remove() not implemented.");
		}

	}
}