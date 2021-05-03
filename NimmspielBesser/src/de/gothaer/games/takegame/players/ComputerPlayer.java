package de.gothaer.games.takegame.players;

public class ComputerPlayer extends AbstractTakeGamePlayer {

	private final int zuege[] = {3,1,1,2}; 
	
	public ComputerPlayer() {
		// ok
	}

	public ComputerPlayer(String name) {
		super(name);
	}

	@Override
	public int doTurn(int stones) {
		int move = zuege[stones % 4];
		System.out.printf("Computer nimmt %s Steine\n", move);
		return move;
	}

}
