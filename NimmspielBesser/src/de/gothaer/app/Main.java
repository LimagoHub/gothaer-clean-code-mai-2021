package de.gothaer.app;

import de.gothaer.clients.GameClient;
import de.gothaer.games.Game;
import de.gothaer.games.takegame.TakeGameImpl;
import de.gothaer.games.takegame.players.ComputerPlayer;
import de.gothaer.games.takegame.players.HumanPlayer;

public class Main {

	public static void main(String[] args) {
		TakeGameImpl game = new TakeGameImpl();
		game.addPlayer(new HumanPlayer());
		game.addPlayer(new ComputerPlayer());
		GameClient client = new GameClient(game);
		client.go();

	}

}
