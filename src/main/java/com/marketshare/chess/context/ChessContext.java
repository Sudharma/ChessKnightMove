package com.marketshare.chess.context;

import java.util.Collection;

import com.marketshare.chess.collection.Board;
import com.marketshare.chess.collection.Square;

/**
 * Context for storing necessary chess config such as {@link Board} details
 * @author spuranik
 *
 */
public final class ChessContext {

	private static ChessContext context;

	private String[][] board;

	private Collection<Square> elapsedMoves;
	
	private Square player1Sqr;
	
	private Square player2Sqr;

	
	private ChessContext() {
		// TODO Auto-generated constructor stub
	}

	public final static ChessContext getInstance() {
		if (context == null) {
			context = new ChessContext();
		}
		return context;

	}

	public String[][] getBoard() {
		return board;
	}

	public void setBoard(String[][] board) {
		this.board = board;
	}

	public Collection<Square> getElapsedMoves() {
		return elapsedMoves;
	}

	public void setElapsedMoves(Collection<Square> elapsedMoves) {
		this.elapsedMoves = elapsedMoves;
	}

	public Square getPlayer1Sqr() {
		return player1Sqr;
	}

	public void setPlayer1Sqr(Square player1Sqr) {
		this.player1Sqr = player1Sqr;
	}

	public Square getPlayer2Sqr() {
		return player2Sqr;
	}

	public void setPlayer2Sqr(Square player2Sqr) {
		this.player2Sqr = player2Sqr;
	}

}
