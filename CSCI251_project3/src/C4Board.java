/**
 * C4Board.java
 * 
 * @author	Derek Brown
 *
 * Purpose:	implement interface methods
 */


public class C4Board implements C4BoardIntf {
	
	private int[][] spot = new int[ROWS][COLS];
	
	// Constructor
	public C4Board() {}
	
	public synchronized void setSpot( int r, int c, int p ) {
		spot[r][c] = p;
	}//end setSpot
	
	public synchronized void clear() {
		for( int r = 0 ; r < ROWS ; r++ ) {
			for( int c = 0 ; c < COLS ; c++ ) {
				spot[r][c] = 0;
			}//end for c
		}//end for r
	}//end clear

	@Override
	public synchronized boolean hasPlayer1Marker(int r, int c) {
		if( spot[r][c] == 1 ) {
			return true;
		}//end if
		return false;
	}//end hasPlayer1Marker

	@Override
	public synchronized boolean hasPlayer2Marker(int r, int c) {
		if( spot[r][c] == 2 ) {
			return true;
		}//end if
		return false;
	}//end hasPlayer2Marker

	@Override
	public synchronized int[] hasWon() {
		int[] winning = {1, 1, 4, 4};
		return null;
	}//end hasWon
}//end C4Board
