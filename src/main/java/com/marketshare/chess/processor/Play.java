package com.marketshare.chess.processor;

import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;

import com.marketshare.chess.collection.Knight;
import com.marketshare.chess.collection.Piece;
import com.marketshare.chess.collection.Player;
import com.marketshare.chess.collection.Square;

/**
 * Common Class across multiple players which plays each player turn after turn
 * <p>
 * 
 * below are highlighting features
 * <li>works with notify and wait mechanism for each player.
 * <li>Thread safe for each player
 * 
 * 
 * @author spuranik
 *
 */
public class Play {

	private boolean blackPlay;

	private boolean whitePlay = true;

	private boolean someWon = false;

	/**
	 * Notifed to play for each turn {@link Knight}
	 */
	public synchronized void startPlaying(Piece piece, Player p) {

		try {

			if (isWhitePlay()) {
				System.out.println("Player 1 Turn [White]");
				Thread.sleep(1500);
				playWhite(piece, p);
				if (someOneWins()) {
					Thread.sleep(2000);
					Thread.currentThread().interrupt();
				}
				whitePlay = false;
				blackPlay = true;
				wait();
			}
			notify();

			if (isBlackPlay()) {
				System.out.println("Player 2 Turn [Black]");
				Thread.sleep(1500);
				playBlack(piece, p);
				if (someOneWins()) {
					Thread.sleep(2000);
					Thread.currentThread().interrupt();
				}
				whitePlay = true;
				blackPlay = false;
				wait();
			}
			notify();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} finally {
		}
	}

	/**
	 * Notifed to play for Black {@link Knight}
	 */
	public synchronized void playBlack(Piece piece, Player p) {
		Collection<Square> possibleMoves = piece.getPossibleMoves(piece
				.getCurrentPosition());
		Optional<Square> min = possibleMoves.stream().min(
				new Comparator<Square>() {
					@Override
					public int compare(Square o1, Square o2) {
						if (o2.getX() - o1.getX() != 0) {
							return o1.getX() - o2.getX();
						}
						if (o2.getY() - o1.getY() != 0) {
							return o2.getY() - o1.getY();
						}
						return 0;
					}
				});
		Square minSquare = min.orElse(new Square());

		piece.move(minSquare);
		if (piece.hasWon()) {
			System.out.println("Player 2 [BLACK] Wins!!!....Hurrey");
			someWon = true;
		}
	}

	public synchronized void playWhite(Piece piece, Player p) {
		Collection<Square> possibleMoves = piece.getPossibleMoves(piece
				.getCurrentPosition());
		Optional<Square> max = possibleMoves.stream().max(
				new Comparator<Square>() {
					@Override
					public int compare(Square o1, Square o2) {
						if (o1.getX() - o2.getX() != 0) {
							return o1.getX() - o2.getX();
						}
						if (o1.getY() - o2.getY() != 0) {
							return o2.getY() - o1.getY();
						}
						return 0;
					}
				});
		Square maxSquare = max.orElse(new Square());
		piece.move(maxSquare);
		if (piece.hasWon()) {
			System.out.println("Player 1 [White] Wins!!!....Hurrey");
			someWon = true;
		}
	}

	public boolean isBlackPlay() {
		return blackPlay;
	}

	public boolean isWhitePlay() {
		return whitePlay;
	}

	public synchronized boolean someOneWins() {
		return someWon;
	}
}
