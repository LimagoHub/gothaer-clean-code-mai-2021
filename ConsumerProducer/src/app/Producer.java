package app;

import java.util.Random;
import java.util.Vector;

public class Producer extends Thread{

	
	
	private Vector<Long> vector;
	private Random random = new Random();

	public Producer(Vector<Long> vector) {
		this.vector = vector;
	}
	
	
	@Override
	public void run() {
		try {
			for (int i = 0; i < 20; i++) {
				long value = random.nextInt(1000) ;
				System.out.println("Producer -> " + value);
				synchronized (vector) {
					vector.add(value);
					vector.notify();
				}
				sleep(value);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
