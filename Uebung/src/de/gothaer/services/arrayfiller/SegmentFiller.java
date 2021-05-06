package de.gothaer.services.arrayfiller;

import java.util.Random;

class SegmentFiller {
	
	private final Segment segment;
	private final Random random = new Random();

	public SegmentFiller(Segment segment) {
		this.segment = segment;
	}
	
	public void fill() {
		for(int i = segment.getStart(); i < segment.getEnde(); i++) {
			segment.getData()[i] = random.nextInt();
		}
	}

}
