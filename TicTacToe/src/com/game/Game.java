package com.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.game.board.AbstractBoard;
import com.game.player.Player;
import com.game.player.PlayerAbstract;

public class Game {
	
	AbstractBoard board;
	List<PlayerAbstract> players;
	private static enum GameStatus {
		DRAW,
		WON,
		IN_PROGRESS
	}

	public Game() {
		players = new ArrayList<PlayerAbstract>();
	}
	
	public void initializeGame(String name1, String name2, AbstractBoard board) {
		PlayerAbstract player1 = new Player(name1, Piece.O);
		PlayerAbstract player2 = new Player(name2, Piece.X);
		players.add(player2);
		players.add(player1);		
		this.board = board;
	}
	
	public void startGame() {
		boolean firstPlayer = true;
		PlayerAbstract player = null;
		Scanner scanner = new Scanner(System.in);
		while(hasGameEnded().equals(GameStatus.IN_PROGRESS)) {
			boolean correctInputRecorded = false;
			int x = -1;
			int y = -1;
			while(!correctInputRecorded) {
				
				System.out.println("Enter coordinates between 0 and " + this.board.getSize());
				System.out.print("Enter first integer: ");
				x = scanner.nextInt();
				System.out.print("Enter second integer: ");
				y = scanner.nextInt();
				
				if((x >= 0 && x <= this.board.getSize() - 1) && (y >= 0 && y <= this.board.getSize() - 1)) {
					if(firstPlayer) {
						player = this.players.get(0);
						boolean isValidMove = makeMove(player, x, y, player.getPiece());
						if(isValidMove == true) {
							correctInputRecorded = true;
							break;
						}
						else {
							System.out.println("Square already marked!!");

						}
					}
					else {
						player = this.players.get(1);
						boolean isValidMove = makeMove(this.players.get(1), x, y, player.getPiece());
						if(isValidMove == true) {
							correctInputRecorded = true;
							break;
						}
						else {
							System.out.println("Square already marked!!");
						}
					}
				}
				else {
					System.out.println("Incorrect response, enter the coordinates again");
				}
			}
			firstPlayer = !firstPlayer;
			getBoard();
		}
		scanner.close();
		GameStatus finalGameStatus = hasGameEnded();

		if(finalGameStatus.equals(finalGameStatus.WON)) {
			System.out.println(player.getName() + " wins !!");
		}
		else {
			System.out.println("Game is drawn");
		}
	}
	
	public GameStatus hasGameEnded() {
		if(hasWon()) {
			return GameStatus.WON;
		}
		else if(board.isBoardFull()) {
			return GameStatus.DRAW;
		}
		else {
			return GameStatus.IN_PROGRESS;			
		}
	}
	
	public void getBoard() {
		Piece[][] board = this.board.getBoard();
		for(int i = 0; i < board.length; i++) {
			for(int j = 0 ; j < board[0].length; j++) {
				if(board[i][j] == null) {
					System.out.print("_" + " ");
				}
				else {					
					System.out.print(board[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	private boolean makeMove(PlayerAbstract player, int i, int j, Piece move ) {
		if(isMoveValid(i, j) == true) {
			this.board.markBoard(i, j, move);
			return true;
		}
		return false;
	}
	
	private boolean hasWon() {
		Piece[][] board = this.board.getBoard();
		int size = this.board.getSize();
		//check rows
		for(int i = 0 ; i < size; i++ ) {
		    boolean rowWin = true;
			for( int j = 1; j < size; j++) {
				if(board[i][j] != board[i][j - 1] || board[i][j] == null) {
				    rowWin = false;
		            break;
				}
			}
			if (rowWin) {			    	
				return true;
			}
		}
		
		//column
		for(int j = 0 ; j < size; j++ ) {
			boolean colWin = true;
			for( int i = 1; i < size; i++) {
				if(board[i][j] != board[i - 1][j] || board[i][j] == null) {
					colWin = false;
					break;
				}
			}
			 if (colWin) {			    	
			    	return true;
		    }
		}
		
		//0 -> n-1 diagonal
		boolean diagWin1 = true;
		for(int i = 1 ; i < size ; i++) {
			if(board[i][i] != board[i-1][i-1] || board[i][i] == null) {
				diagWin1 =  false;
				break;
			}
		}
		boolean diagWin2 = true;

		for(int i = 1, j = size - 2; i < size ;i++, j--) {
			if(board[i - 1][j + 1] != board[i][j] || board[i][j] == null) {
				diagWin2 =  false;
				break;
			}
		}
		return diagWin1 || diagWin2;
	}
	
	private boolean isMoveValid(int i, int j) {
		Piece[][] board = this.board.getBoard();
		if(board[i][j] == null) {
			return true;
		}
		return false;
	}
}
