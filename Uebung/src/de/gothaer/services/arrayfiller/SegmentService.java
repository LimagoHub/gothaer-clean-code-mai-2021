package de.gothaer.services.arrayfiller;

class SegmentService {
	
	private final int feld[];
	private final int segmentSize;
	
	public SegmentService(int[] feld, int segmentCount) {
		this.feld = feld;
		this.segmentSize = feld.length/segmentCount;
	}
	
	public Segment createSegmentByIndex(int index) {
		
		final int start = index * segmentSize;
		final int ende = (index + 1) * segmentSize;
		return new Segment(feld, start, ende);
	}

}