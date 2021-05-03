package de.gothaer.games.takegame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import de.gothaer.games.Game;
import de.gothaer.games.takegame.players.TakeGamePlayer;

public class TakeGameImpl implements Game {
	
	private int stones;
	private int move;
	private List<TakeGamePlayer> players = new ArrayList<>();
	
	public void addPlayer(TakeGamePlayer player) {
		players.add(player);
	}
	
	public void removePlayer(TakeGamePlayer player) {
		players.remove(player);
	}
	
	
	public TakeGameImpl() {
		stones = 23;
		
	}
	
	private boolean isGameOver() {
		return stones < 1 || players.isEmpty();
	}

	@Override
	public void play() {
		while(! isGameOver()) 
			executeTurns();
	}

	private void executeTurns() {
		players.forEach(p->executeTurn(p));
	}

	private void executeTurn(TakeGamePlayer player) {
		
		if(initTurn(player)) return;
		
		
		do {
			move = player.doTurn(stones);
		} while(turnIsInvalid());
		
		terminateTurn(player.getName() + " hat verloren!");
	}
	
	private boolean initTurn(TakeGamePlayer player) {
		System.out.println(player.getName() + " ist am Zug");
		return isGameOver();
	}
	
	private void terminateTurn(String message) {
		calculateBoard();
		checkGameOver(message);
	}
	private boolean turnIsInvalid() {
		boolean invalid = ! isValid();
		if(invalid) {
			System.out.println("Ungültiger Zug");
		}
		return invalid;
	}


	

	private void checkGameOver(String message) {
		if(isGameOver()) {
			System.out.println(message);
		}
	}

	private void calculateBoard() {
		stones -= move;
	}
	private boolean isValid() {
		return move >= 1 && move <= 3;
	}


}
