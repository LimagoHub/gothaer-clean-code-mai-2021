package de.gothaer.games.takegame.players;

import java.util.Scanner;

public class HumanPlayer extends AbstractTakeGamePlayer {
	private final Scanner scanner = new Scanner(System.in);
	public HumanPlayer() {
		// ok
	}

	public HumanPlayer(String name) {
		super(name);
		
	}

	@Override
	public int doTurn(int stones) {
		System.out.println(String.format("Es gibt %s Steine. Bitte nehmen Sie 1,2 oder 3!", stones));
		return scanner.nextInt();
		
	}

}
