package de.gothaer.games.takegame.players;

import de.gothaer.games.players.AbstractPlayer;

public class ComputerPlayer extends AbstractPlayer<Integer, Integer> {

	private final int zuege[] = {3,1,1,2}; 
	
	public ComputerPlayer() {
		// ok
	}

	public ComputerPlayer(String name) {
		super(name);
	}

	@Override
	public Integer doTurn(Integer stones) {
		int move = zuege[stones % 4];
		System.out.printf("Computer nimmt %s Steine\n", move);
		return move;
	}

}
