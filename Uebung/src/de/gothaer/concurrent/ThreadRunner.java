package de.gothaer.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadRunner {
	
	public void executeRunnables(List<Runnable> runnables) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		runnables.forEach(service::execute);
		service.shutdown();
		service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
	}

	public <T> List<Future<T>> executeCallables(List<Callable<T>> callables) throws InterruptedException {
		
		List<Future<T>> retval = new ArrayList<>();
		ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		callables.forEach(c->retval.add(service.submit(c)));
		service.shutdown();
		return retval;
	}

}
