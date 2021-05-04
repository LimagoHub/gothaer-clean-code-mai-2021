package de.gothaer.games.takegame;

import de.gothaer.games.AbstractGame;

public class TakeGameImpl extends AbstractGame<Integer, Integer> {

	public TakeGameImpl() {
		board = 23;
	}

	protected void calculateBoard() {
		board -= move;
	}

	protected boolean isValid() {
		return move >= 1 && move <= 3;
	}

	protected boolean isGameOver() {
		return board < 1 || getPlayers().isEmpty();
	}

}
