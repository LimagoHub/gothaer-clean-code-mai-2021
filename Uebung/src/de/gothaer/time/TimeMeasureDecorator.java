package de.gothaer.time;

import java.time.Duration;
import java.time.Instant;

public class TimeMeasureDecorator {
	
	public void processTimeMeasuring(Runnable runnable) {
		Instant start =Instant.now();
		runnable.run();
		Instant ende =Instant.now();
		
		Duration duration = Duration.between(start, ende);
		System.out.printf("Dauer: %s Millisekunden\n", duration.toMillis());
	}

}
