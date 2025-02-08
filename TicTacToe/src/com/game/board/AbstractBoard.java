package com.game.board;

import com.game.Piece;

public abstract class AbstractBoard {
	private static final int DEFAULT_SIZE = 3;
	protected int size = DEFAULT_SIZE;
	
	protected Piece[][] board;
	
	public Piece[][] getBoard() {
		return board;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void markBoard(int i, int j, Piece move) {
		board[i][j] = move;
	}
	
	public boolean isBoardFull() {
		for(int i = 0 ; i < size; i++) {
			for(int j = 0 ; j < size; j++) {
				if(board[i][j] == null) {
					return false;
				}
			}
		}
		return true;
	}
}
