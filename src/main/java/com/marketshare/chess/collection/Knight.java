package com.marketshare.chess.collection;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

/**
 * <i><b>Is a</b></i> {@link Piece} which has the Knight behaviour.
 * Implementations is specific to Knight movement
 * 
 * @author spuranik
 *
 */
public class Knight extends Piece {

	public Knight(Color color) {
		this.color = color;
	}

	private int[][] offsets = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 },
			{ 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };

	private Color color;

	/** reason for using AL is because of always traversing the list */
	private Stack<Square> movesDone = new Stack<>();

	public Collection<Square> elapsedMoves() {
		return movesDone;
	}

	private Square currentPosition;

	@Override
	public Square getCurrentPosition() {
		return currentPosition;
	}

	@Override
	public void setCurrentPosition(Square currentPosition) {
		this.currentPosition = currentPosition;
	}

	@Override
	public Collection<Square> getPossibleMoves(Square currentPos) {
		return generateMoves(currentPos);
	}

	private List<Square> generateMoves(Square currentPos) {
		List<Square> possibleMoves = new ArrayList<>();
		for (int i = 0; i < offsets.length; i++) {
			Square sq = new Square();
			for (int j = 0; j < 1;) {
				sq.setX(offsets[i][j]);
				sq.setY(offsets[i][++j]);
				possibleMoves.add(sq);
			}
		}

		possibleMoves.stream().forEach(sqr -> {
			sqr.setX(sqr.getX() + currentPos.getX());
			sqr.setY(sqr.getY() + currentPos.getY());
		});

		/** remove if any negative co-ordinates are present */
		possibleMoves.removeIf(sqr -> (sqr.getX() <= 0 || sqr.getX() > 8)
				|| (sqr.getY() <= 0 || sqr.getY() > 8));

		/** if already moved Path then remove from possibleMoves */
		movesDone.forEach(sqr -> {
			possibleMoves.removeIf(possSQ -> possSQ.equals(sqr));
		});

		if (possibleMoves.isEmpty() && !movesDone.isEmpty()) {
			return generateMoves(movesDone.pop());
		}

		return possibleMoves;
	}

	public void move(Square destination) {
		System.out.println("moving to.. " + destination);
		this.currentPosition = destination;
		movesDone.push(destination);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public boolean hasWon() {
		return currentPosition.score() == 63;
	}

	/*
	 * public static void main(String[] args) { new
	 * Knight(Color.BLACK).getPossibleMoves(); }
	 */

}
