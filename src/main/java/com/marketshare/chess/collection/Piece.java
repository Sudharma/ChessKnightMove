package com.marketshare.chess.collection;

import java.util.Collection;

/**
 * A chess piece which will abide by chess laws in order for playing anygame
 * @author spuranik
 *
 */
public abstract class Piece {

	public abstract Collection<Square> getPossibleMoves(Square currentPos);

	public abstract void move(Square destination);
	
	public abstract Square getCurrentPosition();
	
	public abstract void setCurrentPosition(Square position);
	
	public abstract boolean hasWon();
}
