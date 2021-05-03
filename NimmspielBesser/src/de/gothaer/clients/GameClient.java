package de.gothaer.clients;

import de.gothaer.games.Game;

public class GameClient {
	
	private final Game game;
	
	public GameClient(Game game) {
		super();
		this.game = game;
	}

	public void go() {
		game.play();
	}
}
