package com.marketshare.chess.context;

import java.awt.Color;

import com.marketshare.chess.collection.Knight;
import com.marketshare.chess.collection.Player;
import com.marketshare.chess.processor.Game;
import com.marketshare.chess.processor.Play;

/**
 * This class starts the play and delegates to dependent handlers
 * 
 * @author spuranik
 *
 */
public class PlayGame {

	public static void main(String[] args) {
		Play play = new Play();
		Player p1 = new Player(play, new Knight(Color.WHITE));
		Player p2 = new Player(play, new Knight(Color.BLACK));

		helpLine(args);

		Game game = new Game(p1, p2);
		game.readInputs();
		game.startPlay();

	}

	private static void helpLine(String[] args) {
		
		if (args.length == 0)
			return;
		
		if ("--help".equals(args[0]) || "-h".equals(args[0])) {
			System.out
					.println("1. Player has to enter the x and y  co-ordinates to start the game");
			System.out.println("2. Sample Example is for Player 1 --> 2,6");
			System.out.println("3. Sample Example is for Player 2 --> 5,6");
			System.out
					.println("4. comma[','] is the delimiter hence mandatory; any value less < 0 and > 8 is invalid");
			System.out
					.println("5. Attached also is the layout of the chess board, kindly have a look before start");
			System.exit(0);
		}

	}

}
