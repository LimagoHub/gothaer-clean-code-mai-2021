package de.gothaer.services.arrayfiller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ArrayFillService {

	private int feld[] = {};
	private int threadCount = 1;
	private ExecutorService service;

	public ArrayFillService() {

	}

	public ArrayFillService(final int[] feld, final int threadCount) {
		this.feld = feld;
		this.threadCount = threadCount;
	}

	public int[] getFeld() {
		return feld;
	}

	public ArrayFillService setFeld(int[] feld) {
		this.feld = feld;
		return this;
	}

	public int getThreadCount() {
		return threadCount;
	}

	public ArrayFillService setThreadCount(int threadCount) {
		this.threadCount = threadCount;
		return this;
	}

	public void fillParallel() {
		try {
			fillParallelWithThreadpool();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void fillParallelWithThreadpool() throws InterruptedException {
		service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		runWorker();
		service.shutdown();
		service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
	}

	private void runWorker() {
		for (int segmentIndex = 0; segmentIndex < threadCount; segmentIndex++) {
			runSingleWorker(segmentIndex);
		}
	}

	private void runSingleWorker(final int segmentIndex) {
		Segment segment = createSegment(segmentIndex);
		runSegmentFiller(segment);
	}

	private Segment createSegment(final int segmentIndex) {
		return new SegmentService(feld, threadCount).createSegmentByIndex(segmentIndex);
	}

	private void runSegmentFiller(final Segment segment) {
		service.execute(new SegmentFiller(segment)::fill);
	}

	public int findMaxValue() {
		try {
			return findMaxValueImpl();
		} catch (InterruptedException e) {
			e.printStackTrace();
			return Integer.MIN_VALUE;
		}
	}

	private int findMaxValueImpl() throws InterruptedException {
		service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		List<Future<Integer>> maxValues = runFindMaxWorker();
		service.shutdown();
		service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		return maxValues.stream().mapToInt(this::convertFutureToInt).max().getAsInt();
	}

	private List<Future<Integer>> runFindMaxWorker() {
		List<Future<Integer>> maxValues = new ArrayList<>();
		for (int segmentIndex = 0; segmentIndex < threadCount; segmentIndex++) {
			maxValues.add(runSingleFindMaxWorkerWorker(segmentIndex));
		}
		return maxValues;
	}

	private Future<Integer> runSingleFindMaxWorkerWorker(final int segmentIndex) {
		Segment segment = createSegment(segmentIndex);
		return service.submit(new SegmentMaxFinder(segment)::findMaxValue);
	}

	int convertFutureToInt(Future<Integer> f) {
		try {
			return f.get();
		} catch (Exception e) {
			return Integer.MIN_VALUE;
		}
	}
}
