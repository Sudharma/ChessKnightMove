package com.marketshare.chess.collection;

import com.marketshare.chess.processor.Play;

/**
 * An executing thread which is handled by the {@link Play} and manages to play
 * its own strategy after each turn
 * <p>
 * Additionally represents the player Black/White
 * 
 * @author spuranik
 *
 */
public class Player implements Runnable {

	/** play for a Player */
	private Play play;

	/* every player has a piece */
	private Piece piece;

	public Player(final Play play, Piece piece) {
		this.play = play;
		this.piece = piece;
	}

	public Piece getPiece() {
		return piece;
	}

	@Override
	public void run() {
		while (!play.someOneWins()) {
			play.startPlaying(piece, this);
		}
	}

}
