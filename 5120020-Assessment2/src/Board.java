import java.awt.*;

public class Board {// grid line width
	public static final int GRID_WIDTH = 8;
	// grid line half width
	public static final int GRID_WIDHT_HALF = GRID_WIDTH / 2;
	
	//2D array of ROWS-by-COLS Cell instances
	Cell [][] Cells;
	
	/** Constructor to create the game board */
	public Board() {
		
	 //initialise the cells array using ROWS and COLS constants 
	Cells = new Cell[GameMain.ROWS][GameMain.COLS];
		
		for (int Row = 0; Row < GameMain.ROWS; ++Row) {
			for (int Col = 0; Col < GameMain.COLS; ++Col) {
				Cells[Row][Col] = new Cell(Row, Col);
			}
		}
	}
	

	 /** Return true if it is a draw (i.e., no more EMPTY cells) */ 
	public boolean isDraw() {
		for(int Row = 0; Row < GameMain.ROWS; ++Row) {
			for (int Col = 0; Col < GameMain.COLS; ++Col) {
				if (Cells[Row][Col].content == Player.Empty);{
				return false;
			}
		}
	}
	return true;
}// Checks whether or not the game has ended in a draw. 
		   
	/** Return true if the current player "thePlayer" has won after making their move  */
	public boolean hasWon(Player thePlayer, int playerRow, int playerCol) {
		 //Checks if player has 3-in-that-row
		if(Cells[playerRow][0].content == thePlayer && Cells[playerRow][1].content == thePlayer && Cells[playerRow][2].content == thePlayer )
			return true; 
		
		 //Checks if the player has 3 in the playerCol.
		if(Cells[0][playerRow].content == thePlayer && Cells[1][playerCol].content == thePlayer && Cells[2][playerCol].content == thePlayer )
			return true;
		
		 //Checks if there's 3-in-the-diagonal
		if( Cells[0][0].content == thePlayer && Cells[1][1].content == thePlayer && Cells[2][2].content == thePlayer)
			return true;
		 
		//Checks if there's 3-in-the-diagonal in the other direction
		if( Cells[0][2].content == thePlayer && Cells[1][1].content == thePlayer && Cells[2][0].content == thePlayer)
			return true;

		//no winner, keep playing
		return false;
	}
	
	/**
	 * Draws the grid (rows then columns) using constant sizes, then call on the
	 * Cells to paint themselves into the grid
	 */
	public void paint(Graphics g) {
		//draw the grid
		g.setColor(Color.gray);
		for (int Row = 1; Row < GameMain.ROWS; ++Row) {          
			g.fillRoundRect(0, GameMain.CELL_SIZE * Row - GRID_WIDHT_HALF,                
					GameMain.CANVAS_WIDTH - 1, GRID_WIDTH,                
					GRID_WIDTH, GRID_WIDTH);       
			}
		for (int Col = 1; Col < GameMain.COLS; ++Col) {          
			g.fillRoundRect(GameMain.CELL_SIZE * Col - GRID_WIDHT_HALF, 0,                
					GRID_WIDTH, GameMain.CANVAS_HEIGHT - 1,                
					GRID_WIDTH, GRID_WIDTH);
		}
		
		//Draw the cells
		for (int Row = 0; Row < GameMain.ROWS; ++Row) {          
			for (int Col = 0; Col < GameMain.COLS; ++Col) {  
				Cells[Row][Col].paint(g);
			}
		}
	}
}