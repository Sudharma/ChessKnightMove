package com.marketshare.chess.util;

import com.marketshare.chess.collection.Square;

/***
 * Utility for Chess activites
 * 
 * @author spuranik
 *
 */
public class ChessUtil {

	public static void coordinatesToValues(Square square) {
		String[] split = square.getPositon().split(",");
		square.setX(Integer.parseInt(split[0]));
		square.setY(Integer.parseInt(split[1]));
	}

}
