package com.game.player;

import com.game.Piece;

public abstract class PlayerAbstract {
	protected String name;
	protected Piece piece;
	
	public String getName() {
		return this.name;
	}
	
	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public Piece getPiece() {
		return this.piece;
	}
}
