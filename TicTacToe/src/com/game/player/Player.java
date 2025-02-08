package com.game.player;

import com.game.Piece;

public class Player extends PlayerAbstract {
	
	public Player(String name) {
		this.name = name;
	}

	public Player(String name, Piece piece) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.piece = piece;
	}

}
