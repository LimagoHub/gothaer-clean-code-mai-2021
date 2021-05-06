package de.gothaer.concurrent;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadRunner {
	
	public void executeRunnables(List<Runnable> runnables) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		runnables.forEach(service::execute);
		service.shutdown();
		service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
	}

}
