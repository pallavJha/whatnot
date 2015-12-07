package pl.misc.sedgewick.chap01;

public class ResizingArrayQueueOfStrings<T> {

	T arr[];
	int start = -1;
	int end = -1;

	@SuppressWarnings("unchecked")
	ResizingArrayQueueOfStrings(int cap) {
		arr = (T[]) new Object[cap];
	}

	public void enqueue(T item) {
		if (start == end && start == -1) {
			start = end = 0;
			arr[end] = item;
			System.out.println(this.toString());
			return;
		}
		if (end == arr.length - 1) {
			resize(true);
		}
		arr[++end] = item;
		System.out.println(this.toString());
	}

	public T dequeue() {
		T item = arr[start];
		start++;
		if (start > end) {
			start = end = -1;
			resize(false);
		}
		System.out.println(this.toString());
		return item;
	}

	@SuppressWarnings("unchecked")
	public void resize(boolean increase) {
		if (increase) {
			int newSize = increase ? arr.length * 2 : arr.length / 2;
			T temp[] = (T[]) new Object[newSize];
			for (int i = 0; i < arr.length; i++) {
				temp[i] = arr[i];
			}
			arr = temp;
		} else {
			arr = (T[]) new Object[3];
		}
	}

	public String toString() {
		String s = "";
		for (int i = start; i < end; i++) {
			s += arr[i] + "->";
		}
		s += end > -1 ? arr[end].toString() : "";
		return s;
	}

	public static void main(String... strings) {
		ResizingArrayQueueOfStrings<Integer> queue = new ResizingArrayQueueOfStrings<Integer>(
				3);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(6);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
	}
}