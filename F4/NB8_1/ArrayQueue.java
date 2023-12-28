
package F4.NB8_1;

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
        rear = (rear+1)%maxSize;
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
			size--;
			E element = data[front];
			front = (front+1)%maxSize;
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
		ArrayQueue<String> arrayQueue = new ArrayQueue<>(5);

		//Test 1 reallocate offer
		/*
		System.out.println(arrayQueue.toString());
		arrayQueue.offer("1");
		arrayQueue.offer("2");
		arrayQueue.offer("3");
		arrayQueue.offer("4");
		System.out.println(arrayQueue.toString());
		arrayQueue.offer("5");
		System.out.println(arrayQueue.toString());
		arrayQueue.offer("6");
		System.out.println(arrayQueue.toString());
		*/
		// Funkar att göra större.

		//Test 2 reallocate offer and poll
		System.out.println(arrayQueue.toString());
		arrayQueue.offer("1");
		arrayQueue.offer("2");
		arrayQueue.offer("3");
		arrayQueue.offer("4");
		System.out.println(arrayQueue.toString());
		System.out.println(arrayQueue.poll());
		arrayQueue.offer("5");
		arrayQueue.offer("6");
		// Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
		// sätter paranteser på rad 22         rear = (rear+1)%maxSize;
		System.out.println(arrayQueue.toString());
		arrayQueue.offer("7");
		arrayQueue.offer("8");
		//Här börjar den köra över element 2 och 3
		//fixa genom o skriva om reallocate helt.
		System.out.println(arrayQueue.toString());

		//Test 3
		arrayQueue.offer("9");
		arrayQueue.offer("10");
		arrayQueue.offer("11");
		System.out.println(arrayQueue.poll());
		System.out.println(arrayQueue.poll());
		System.out.println(arrayQueue.poll());
		System.out.println(arrayQueue.poll());
		System.out.println(arrayQueue.poll());
		System.out.println(arrayQueue.poll());
		System.out.println(arrayQueue.poll());
		System.out.println(arrayQueue.poll());
		System.out.println(arrayQueue.poll());
		System.out.println(arrayQueue.poll());


		arrayQueue.offer("13");
		arrayQueue.offer("14");
		System.out.println(arrayQueue.toString());
		//Här vart front=10;
		//Addera till paranterser på rad 38 front = (front+1)%maxSize;
		//Nu är allt i sin ordning.


	}


}