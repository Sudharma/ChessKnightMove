package com.marketshare.chess.processor;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.marketshare.chess.collection.Player;
import com.marketshare.chess.collection.Square;
import com.marketshare.chess.context.ChessContext;

/**
 * Consisting of {@link Player}s and starting a game
 * 
 * @author spuranik
 *
 */
public class Game {

	private Player player1;

	private Player player2;

	public Game(Player p1, Player p2) {
		this.player1 = p1;
		this.player2 = p2;
	}

	public void startPlay() {
		Thread t1 = new Thread(player1);
		Thread t2 = new Thread(player2);
		t1.start();
		t2.start();
	}

	public void readInputs() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out
					.println("Enter Knight position 'X','Y' for Player 1 [ WHITE ]");
			if (sc.hasNext()) {
				String x1y1 = sc.next();
				if (!validInput(x1y1)) {
					readInputs();
				}
				Square square1 = new Square();
				square1.setPositon(x1y1);
				square1.normalizeCoordinates();
				this.player1.getPiece().setCurrentPosition(square1);
				ChessContext.getInstance().setPlayer1Sqr(square1);
			}

			System.out
					.println("Enter Knight position 'X','Y' for Player 2 [ BLACK ]");
			if (sc.hasNext()) {
				String x2y2 = sc.next();
				if (!validInput(x2y2)) {
					readInputs();
				}
				Square square2 = new Square();
				square2.setPositon(x2y2);
				square2.normalizeCoordinates();
				this.player2.getPiece().setCurrentPosition(square2);
				ChessContext.getInstance().setPlayer2Sqr(square2);
			}
		} finally {
			sc.close();
		}
	}

	private boolean validInput(String xy) {
		Pattern p = Pattern.compile("[1-8],[1-8]");
		Matcher m = p.matcher(xy);
		if (!m.find()) {
			System.err
					.println("INCORRECT INPUT PROVIDED!!!, please provide proper input");
			return false;
		}

		if (ChessContext.getInstance().getPlayer1Sqr() != null) {
			if (ChessContext.getInstance().getPlayer1Sqr().getPositon()
					.equals(xy)) {
				System.err
						.println("Same Position cannot be occupied by both Players!!");
				return false;
			}
		}
		return true;
	}

}
