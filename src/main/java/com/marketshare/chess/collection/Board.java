package com.marketshare.chess.collection;

import com.marketshare.chess.context.ChessContext;

/**
 * Basic Board for chess
 * 
 * @author spuranik
 *
 */
public class Board {

	private String[][] board;

	public String[][] getBoard() {
		return board;
	}

	public void setBoard(String[][] board) {
		this.board = board;
	}

	/**
	 * Initialize chess board as of now only 8x8 is supported
	 * 
	 * @param x
	 * @param y
	 */
	protected void initializeBoard(int x, int y) {
		board = generateBoard(x, y);
		ChessContext.getInstance().setBoard(board);
	}

	private static String[][] generateBoard(int x, int y) {
		String[][] board = new String[x][y];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = (i + 1) + "," + (j + 1);
			}
		}
		return board;
	}

	private static void printArray(String[][] chess) {
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess.length; j++) {
				System.out.printf("%5s", chess[i][j]);
			}
			System.out.println();
		}
	}

	public static void flipInPlace(String[][] theArray) {
		for (int i = 0; i < (theArray.length / 2); i++) {
			String[] temp = theArray[i];
			theArray[i] = theArray[theArray.length - i - 1];
			theArray[theArray.length - i - 1] = temp;
		}
	}

}
