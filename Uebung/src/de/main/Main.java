package de.main;

import de.gothaer.services.arrayfiller.ArrayFillService;
import de.gothaer.time.TimeMeasureDecorator;

public class Main {

	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE / 2;
	private int feld[] = new int[MAX_ARRAY_SIZE];
	private final TimeMeasureDecorator decorator;
	private final ArrayFillService arrayFillService;
	private int threadCount;

	public static void main(String[] args) {
		new Main(new TimeMeasureDecorator(), new ArrayFillService()).run();
	}

	public Main(final TimeMeasureDecorator decorator, final ArrayFillService arrayFillService) {
		this.decorator = decorator;
		this.arrayFillService = arrayFillService;
	}

	private void run() {
		fillArrayWithRandomNumbers();
	}

	private void fillArrayWithRandomNumbers() {
		for (threadCount = 1; threadCount <= Runtime.getRuntime().availableProcessors() + 1; threadCount++) {
			fillArrayWithTimeAnalyzer();
		}

	}

	private void fillArrayWithTimeAnalyzer() {
		decorator.processTimeMeasuring(this::fillArrayWithParallelArrayFillService);
	}

	private void fillArrayWithParallelArrayFillService() {
		System.out.printf("\nArray wird mit %s Threads befüllt...\n", threadCount);
		arrayFillService.setFeld(feld).setThreadCount(threadCount).fillParallel();
	}

}
