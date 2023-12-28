
package F4.NB8;

import java.util.Arrays;

public class ArrayQueue<E>{
	private int front, rear, size, maxSize;
	private E[] data;

	public ArrayQueue(int initialSize){
		size = 0;
		front = 0;
		maxSize = initialSize;
		rear = 0;
		data = (E[]) new Object[maxSize];
	}

	public boolean offer(E element){
		if(size==maxSize)
			reallocate();
		data[rear] = element;
        rear = (rear+1) % maxSize;
		size++;
		return true;
	}

	public E peek(){
		if(size==0) return null;
		return data[front];
	}

	public E poll(){
		if(size==0){
			return null;
		}else{
			System.out.println("********" + size);
			if(size <= maxSize/4 && size < 10) resize();
			size--;
			E element = data[front];
			front = (front+1) % maxSize;
			return element;
		}	
	}

	private void reallocate() {
		E[] nData = (E[]) new Object[maxSize * 2];
		for(int i = 0; i < size; i++){
			nData[i] = data[(front + i)%maxSize];
		}
		front = 0;
		rear = size;
		maxSize = maxSize*2;
		data = nData;
	}

	private void resize() {
		System.out.println("INNE I RESIZE");
		E[] nData = (E[]) new Object[maxSize / 2];
		for(int i = 0; i < size; i++){
			nData[i] = data[(front + i)%maxSize];
		}
		front = 0;
		rear = size;
		maxSize = maxSize/2;
		data = nData;
	}

	@Override
	public String toString() {
		return "ArrayQueue{" +
				"front=" + front +
				", rear=" + rear +
				", size=" + size +
				", maxSize=" + maxSize +
				", data=" + printQueue() +
				'}';
	}

	private String printQueue(){
		if(size == 0){
			return "Queue is Empty";
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size; i++){
			if(i > 0){
				sb.append(", ");
			}
			sb.append(data[(front + i) % maxSize]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		ArrayQueue<String> arrayQueue = new ArrayQueue<>(10);
		arrayQueue.offer("Alex1");
		arrayQueue.offer("Alex2");
		arrayQueue.offer("Alex3");
		arrayQueue.offer("Alex4");
		arrayQueue.offer("Alex5");
		arrayQueue.offer("Alex6");
		arrayQueue.offer("Alex7");
		arrayQueue.offer("Alex8");
		arrayQueue.offer("Alex9");
		/*System.out.println(arrayQueue.toString());
		arrayQueue.offer("Alex10");
		arrayQueue.offer("Alex11");
		arrayQueue.offer("Alex12");
		arrayQueue.offer("Alex13");
		arrayQueue.offer("Alex14");
		System.out.println(arrayQueue.toString());*/


		System.out.println(arrayQueue.poll());
		System.out.println(arrayQueue.poll());
		System.out.println(arrayQueue.poll());
		System.out.println(arrayQueue.poll());
		arrayQueue.offer("Alex10");
		arrayQueue.offer("Alex11");
		arrayQueue.offer("Alex12");
		arrayQueue.offer("Alex10");
		arrayQueue.offer("Alex11");
		arrayQueue.offer("Alex12");
		System.out.println(arrayQueue.poll());
		System.out.println(arrayQueue.poll());
		System.out.println(arrayQueue.poll());
		System.out.println(arrayQueue.poll());
		System.out.println(arrayQueue.poll());
		System.out.println(arrayQueue.poll());
		System.out.println(arrayQueue.poll());
		System.out.println(arrayQueue.poll());
		System.out.println(arrayQueue.poll());
		System.out.println(arrayQueue.toString());
		/*
		System.out.println(arrayQueue.poll());
		System.out.println(arrayQueue.poll());
		System.out.println(arrayQueue.poll());
		System.out.println(arrayQueue.toString());
		System.out.println(arrayQueue.poll());
		System.out.println(arrayQueue.toString());
		System.out.println(arrayQueue.poll());
		System.out.println(arrayQueue.toString());
		*/
		}


}