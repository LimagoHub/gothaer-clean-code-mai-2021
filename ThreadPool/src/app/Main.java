package app;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws Exception{
		int availableProcessors = Runtime.getRuntime().availableProcessors();
		System.out.println(availableProcessors);
		
		ExecutorService service = Executors.newFixedThreadPool(availableProcessors);
//		for (int i = 0; i < 20; i++) {
//			service.execute(new Worker());
//		}
//		service.shutdown();
//		service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		
		Future<Integer> f1 = service.submit(new MyOtherWorker());
		Future<Integer> f2  = service.submit(new MyOtherWorker());
		
		service.shutdown();
		
		System.out.println(f1.get());
		System.out.println(f2.get());
		
		System.out.println("Fertig");

	}
	
	static class Worker implements Runnable {

		@Override
		public void run() {

			try {
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getId() + " hat fertig");
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}
	
	static class MyOtherWorker implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {
			try {
				Thread.sleep(2000);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			return (int) Thread.currentThread().getId();
		}
		
	}

}
