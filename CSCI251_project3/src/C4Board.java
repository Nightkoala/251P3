/**
 * C4Board.java
 * 
 * @author	Derek Brown
 *
 * Purpose:	implement interface methods
 */

import java.util.Arrays;

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
		int[] winner = new int[4];
		int current = 0;
		int length = 0;
		// for each row check for winner
		for( int r = 0 ; r < ROWS ; r++ ) {
			for( int c = 0 ; c < COLS ; c++ ) {
				if( current != spot[r][c] ) {
//					Arrays.fill(winner, 0);
					current = spot[r][c];
					length = 0;
				}//end if
				if( current == spot[r][c] ) {
					if( current != 0 ) {
						if( length == 0 ) {
							winner[0] = r;
							winner[1] = c;
							length++;
						}//end if
						else if( length == 4) {
							winner[2] = r;
							winner[3] = c;
							return winner;
						}//end else if
						else {
							length++;
						}//end else
					}//end if
				}//end if
			}//end for c
		}//end for r
		// for each column check for winner
		current = 0;
		length = 0;
		for( int c = 0 ; c < COLS ; c++ ) {
			for( int r = 0 ; r < ROWS ; r++ ) {
				if( current != spot[r][c] ) {
//					Arrays.fill(winner, 0);
					current = spot[r][c];
					winner[0] = r;
					winner[1] = c;
					length = 1;
				}//end if
				if( current == spot[r][c] ) {
					if( current != 0 ) {
//						if( length == 0 ) {
//							winner[0] = r;
//							winner[1] = c;
//							length++;
//						}//end if
						if( length == 4) {
							winner[2] = r;
							winner[3] = c;
							return winner;
						}//end else if
						else {
							length++;
						}//end else
					}//end if
				}//end if
			}//end for r
		}//end for c
		return null;
	}//end hasWon
}//end C4Board
