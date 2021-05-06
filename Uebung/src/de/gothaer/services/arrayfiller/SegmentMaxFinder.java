package de.gothaer.services.arrayfiller;

public class SegmentMaxFinder {

	private final Segment segment;
	
	public SegmentMaxFinder(Segment segment) {
		this.segment = segment;
	}
	
	public Integer findMaxValue() {
		int max = segment.getData()[segment.getStart()];
		for(int i = segment.getStart()+1; i < segment.getEnde(); i++) {
			max = max > segment.getData()[i]?max:segment.getData()[i];
		}
		return max;
	}
}
