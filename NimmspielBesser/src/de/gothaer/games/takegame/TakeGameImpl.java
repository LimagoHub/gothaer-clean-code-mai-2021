package de.gothaer.games.takegame;

import java.util.Scanner;

import de.gothaer.games.Game;

public class TakeGameImpl implements Game {
	private final Scanner scanner = new Scanner(System.in);
	private int stones;
	private boolean gameover;
	
	public TakeGameImpl() {
		stones = 23;
		gameover = false;
	}

	@Override
	public void play() {
		while(! gameover) {
			humanTurn();
			computerTurn();
		}

	}

	private void humanTurn() {
		int move;
		
		while(true) {
			System.out.println(String.format("Es gibt %s Steine. Bitte nehmen Sie 1,2 oder 3!", stones));
			move = scanner.nextInt();
			if( move >= 1 && move <= 3) break;
			System.out.println("Ungültiger Zug");
		}
		
		stones -= move;
		
	}

	private void computerTurn() {
		final int zuege[] = {3,1,1,2}; 
		int move;
		
		if(stones == 1) {
			System.out.println("Du hast nur Glueck gehabt!");
			gameover = true;
			return;
		}
		if(stones < 1) {
			System.out.println("Du Loser");
			gameover = true;
			return;
		}
		
		move = zuege[stones % 4];
		System.out.printf("Computer nimmt %s Steine\n", move);
		stones -= move;
		
	}

}
