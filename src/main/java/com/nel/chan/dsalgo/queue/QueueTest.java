package com.nel.chan.dsalgo.queue;

import com.nel.chan.dsalgo.queue.impl.QueueArrayImpl;

public class QueueTest {

	public static void main(String[] args) {
		Queue<Integer> q = new QueueArrayImpl<>(100);

		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		
		q.print();
		System.out.println("size = " + q.size());
		System.out.println(q.dequeue() +  " dequeued from queue");
		q.print();
		System.out.println("size = " + q.size());
		System.out.println("front = " +  q.front() + " ,rear = " + q.rear()); 
		
		System.out.println(q.dequeue() +  " dequeued from queue");
		q.print();
		System.out.println("size = " + q.size());
		

		System.out.println(q.dequeue() +  " dequeued from queue");
		q.print();
		System.out.println("size = " + q.size());

		if (q.isEmpty()) {
			System.out.println("Queue Is Empty");
		}
		else {
			System.out.println("Queue Is Not Empty");
		}
	}
}