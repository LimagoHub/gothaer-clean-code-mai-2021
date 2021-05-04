package de.gothaer.games.players;

public abstract class AbstractPlayer<B,M> implements Player<B, M> {

private String name = getClass().getSimpleName();
	
	public AbstractPlayer() {
		// Ok
	}
	
	public AbstractPlayer(String name) {
		this.name = name;
	}
	
	
	@Override
	public String getName() {
		return name;
	}
}
