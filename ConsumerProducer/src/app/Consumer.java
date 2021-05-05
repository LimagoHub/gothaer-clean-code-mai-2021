package app;

import java.util.Vector;

public class Consumer extends Thread {

	private Vector<Long> vector;

	public Consumer(Vector<Long> vector) {
		this.vector = vector;
	}

	@Override
	public void run() {

		try {
			while (true) {
				if (vector.isEmpty()) {
					synchronized (vector) {
						vector.wait();
					}
				}
				long value = vector.remove(vector.size() - 1);
				System.out.println("Consumer <- " + value);

			}
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}
