package de.gothaer.services.arrayfiller;

class Segment {
	
	private final int data[];
	private final int start;
	private final int ende;
	
	public Segment(int[] data, int start, int ende) {
		this.data = data;
		this.start = start;
		this.ende = ende;
	}

	public int[] getData() {
		return data;
	}

	public int getStart() {
		return start;
	}

	public int getEnde() {
		return ende;
	}
	
	

}
