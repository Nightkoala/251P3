/**
 * C4Board.java
 * 
 * @author	Derek Brown
 *
 * Purpose:	implement interface methods
 */

import java.awt.Color;

public class C4Board implements C4BoardIntf {
	
	private static final Color P1_COLOR = new Color (255, 0, 0);
	private static final Color P2_COLOR = new Color (255, 255, 0);
	private Color[][] spot = new Color[ROWS][COLS];
	
	// Constructor
	public C4Board() {}

	@Override
	public boolean hasPlayer1Marker(int r, int c) {
		if( spot[r][c] == P1_COLOR ) {
			return true;
		}//end if
		return false;
	}//end hasPlayer1Marker

	@Override
	public boolean hasPlayer2Marker(int r, int c) {
		if( spot[r][c] == P2_COLOR ) {
			return true;
		}//end if
		return false;
	}//end hasPlayer2Marker

	@Override
	public int[] hasWon() {
		return null;
	}//end hasWon
}//end C4Board
