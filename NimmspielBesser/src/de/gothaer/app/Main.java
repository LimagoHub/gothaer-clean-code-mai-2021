package de.gothaer.app;

import de.gothaer.clients.GameClient;
import de.gothaer.games.Game;
import de.gothaer.games.takegame.TakeGameImpl;

public class Main {

	public static void main(String[] args) {
		Game game = new TakeGameImpl();
		
		GameClient client = new GameClient(game);
		client.go();

	}

}
