package de.gothaer.games;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.gothaer.games.players.Player;

public abstract class AbstractGame<B,M> implements Game {

	protected B board;
	protected M move;
	
	protected Player<B, M> currentPlayer;
	
	private List<Player<B, M>> players = new ArrayList<>();
		
	public List<Player<B,M>> getPlayers() {
		return Collections.unmodifiableList(players);
	}

	public void addPlayer(Player<B, M> player) {
		players.add(player);
	}
	
	public void removePlayer(Player<B, M> player) {
		players.remove(player);
	}
	
	protected abstract boolean isGameOver();
	protected abstract void calculateBoard() ;
	protected abstract boolean isValid() ;

	
	@Override
	public final void play() {
		while(! isGameOver()) 
			executeTurns();
	}
	
	private void executeTurns() {
		players.forEach(p->executeTurn(p));
	}
	
	private void executeTurn(Player<B, M> player) {
		currentPlayer = player;
		executeSingleTurnWithCurrentPlayer();
	}

	private void executeSingleTurnWithCurrentPlayer() {
		
		if(initTurn()) return;
		
		tryExcecuteTurn();
		
		terminateTurn();
	}

	private void tryExcecuteTurn() {
		do {
			move = currentPlayer.doTurn(board);
		} while(turnIsInvalid());
	}

	private boolean initTurn() {
		print(String.format("Spieler %s ist am Zug.",currentPlayer.getName()));
		return isGameOver();
	}
	
	private void terminateTurn() {
		calculateBoard();
		checkGameOver();
	}
	
	private boolean turnIsInvalid() {
		boolean invalid = ! isValid();
		if(invalid) {
			print("Ungültiger Zug");
		}
		return invalid;
	}


	private void checkGameOver() {
		if(isGameOver()) {
			print(String.format("Spieler %s hat verloren", currentPlayer.getName()));
		}
	}
	
	
	
	

	private void print(String message) {
		System.out.println(message);
	}
}
