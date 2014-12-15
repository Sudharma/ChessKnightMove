package com.marketshare.chess.collection;

public class test {



	public static void main(String[] args) {
		int chess[][] = new int[8][8];
		for (int i = 0; i <chess.length; i++) {
			for (int j = 0; j < chess.length; j++) {
				
			}
		}
		System.out.println("############### BEFORE FLIP ###############");
		printArray(chess);
		flipInPlace(chess);
		System.out.println("############### AFTER FLIP ###############");
		printArray(chess);
	}

	private static void printArray(int[][] chess) {
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess.length; j++) {
				System.out.printf("%5d %d", i, j);
			}
			System.out.println();
		}
	}

	public static void flipInPlace(int[][] theArray) {
		for (int i = 0; i < (theArray.length / 2); i++) {
			int[] temp = theArray[i];
			theArray[i] = theArray[theArray.length - i - 1];
			theArray[theArray.length - i - 1] = temp;
		}
	}


}
