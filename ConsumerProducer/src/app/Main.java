package app;

import java.util.Vector;


public class Main {

	public static void main(String[] args) {
		Vector<Long> vector = new Vector<Long>();
		
		Producer producer = new Producer(vector);
		Consumer consumer = new Consumer(vector) ;
		
		producer.start();
		consumer.start();
	}

}
