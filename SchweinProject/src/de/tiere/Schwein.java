package de.tiere;

public class Schwein {
	
	private String name;
	private volatile int gewicht;
	
	
	public Schwein() {
		this("nobody");
	}


	public Schwein(String name) {
		setGewicht(10);
		setName(name);
	}


	public String getName() {
		return name;
	}



	public final void setName(String name) {
		this.name = name;
	}


	public int getGewicht() {
		return gewicht;
	}


	private void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}
	
	public void fressen() {
		try {
			Thread.sleep(2000);
			setGewicht(getGewicht() + 1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Schwein [name=");
		builder.append(name);
		builder.append(", gewicht=");
		builder.append(gewicht);
		builder.append("]");
		return builder.toString();
	}

}
