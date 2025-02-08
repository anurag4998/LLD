package com.game.board;

import java.util.Arrays;

import com.game.Piece;

public class Board extends AbstractBoard {

	public Board(int size) {
		this.size = size;
		board = new Piece[this.size][this.size];		
	}

	public Board() {
		board = new Piece[this.size][this.size];
	}
}