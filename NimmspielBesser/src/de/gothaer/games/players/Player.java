package de.gothaer.games.players;

public interface Player<B,M> {
	String getName();
	
	M doTurn(B board);
}
