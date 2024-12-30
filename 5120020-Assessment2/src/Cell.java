import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Cell {//content of this cell (empty, cross, nought)
	Player content;
	//row and column of this cell
	int Row, Col;
	
	/** Constructor to initialise this cell with the specified row and col */
	public Cell(int Row, int Col) {
		
		//Initialises both the row and col variables 
		this.Col = Col;
		this.Row = Row;
		this.content = Player.Empty;
		//Calls the method that sets the cell content to EMPTY
		clear();
	} 
	
	public void setContent(Player content) {
		this.content = content;
	}
	
	public Player getContent() {
		return content;
	}

	/** Paint itself on the graphics canvas, given the Graphics context g */ 
	public void paint(Graphics g) {
		//Graphics2D allows setting of pen's stroke size
		Graphics2D graphic2D = (Graphics2D) g;
		graphic2D.setStroke(new BasicStroke(GameMain.SYMBOL_STROKE_WIDTH, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		
		//draw the symbol in the position
		int x1 = Col * GameMain.CELL_SIZE + GameMain.CELL_PADDING;
		int y1 = Row * GameMain.CELL_SIZE + GameMain.CELL_PADDING;
		if (content == Player.Cross) {
			graphic2D.setColor(Color.RED);
			int x2 = (Col + 1) * GameMain.CELL_SIZE - GameMain.CELL_PADDING;
			int y2 = (Row + 1) * GameMain.CELL_SIZE - GameMain.CELL_PADDING;
			graphic2D.drawLine(x1, y1, x2, y2);
			graphic2D.drawLine(x2, y1, x1, y2);
		}else if (content == Player.Nought) {
			graphic2D.setColor(Color.BLUE);
			graphic2D.drawOval(x1, y1, GameMain.SYMBOL_SIZE, GameMain.SYMBOL_SIZE);
		}
	}
	
	/** Set this cell's content to EMPTY */
	public void clear() {
		
		//Sets the value of content to Empty
		this.content = Player.Empty;
		
	}		
}