package com.marketshare.chess.collection;

import com.marketshare.chess.util.ChessUtil;

/**
 * This class represents each square on the chess board
 * 
 * @author spuranik
 *
 */
public class Square {

	private int x;

	private int y;

	private String positon;

	private boolean occupied;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public String getPositon() {
		return positon;
	}

	public void setPositon(String positon) {
		this.positon = positon;
	}

	/**
	 * takes the string position and converts it into the x and y axis
	 * co-ordinates appropriately
	 * 
	 * @return
	 */
	public Square normalizeCoordinates() {
		ChessUtil.coordinatesToValues(this);
		return this;
	}

	/**
	 * Score is absolute difference to get to highest right bottom corner
	 * 
	 * @return
	 */
	public int score() {
		return Math.abs(x * x - y * y);
	}

	@Override
	public String toString() {
		return x + "," + y;
	}

	@Override
	public boolean equals(Object obj) {
		Square input = (Square) obj;
		if (input.getX() == this.x && input.getY() == y) {
			return true;
		} else {
			return false;
		}

	}
}
