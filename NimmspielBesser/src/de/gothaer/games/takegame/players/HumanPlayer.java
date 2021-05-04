package de.gothaer.games.takegame.players;

import java.util.Scanner;

import de.gothaer.games.players.AbstractPlayer;

public class HumanPlayer extends AbstractPlayer<Integer, Integer> {
	private final Scanner scanner = new Scanner(System.in);
	public HumanPlayer() {
		// ok
	}

	public HumanPlayer(String name) {
		super(name);
		
	}

	@Override
	public Integer doTurn(Integer stones) {
		System.out.println(String.format("Es gibt %s Steine. Bitte nehmen Sie 1,2 oder 3!", stones));
		return scanner.nextInt();
		
	}

}
