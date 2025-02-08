package driver;

import java.util.Scanner;

import com.game.Game;
import com.game.Piece;
import com.game.board.AbstractBoard;
import com.game.board.Board;
import com.game.player.Player;
import com.game.player.PlayerAbstract;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
		AbstractBoard board = new Board();
		
		game.initializeGame("player1" , "player2" , board);
		game.startGame();

	}

}
