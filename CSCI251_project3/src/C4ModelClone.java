/**
 * C4ModelClone.java
 * 
 * @author	Derek Brown
 *
 * Purpose
 */

import java.io.IOException;

public class C4ModelClone implements ModelListener {
	
	// Hidden Data Members
	
	private C4Board board = new C4Board();
	private ModelListener modelListener;
	private int p;
	
	// Constructor
	
	public C4ModelClone() {}//end C4ModelClone constructor
	
	// Methods
	
	public C4Board getBoard() {
		return board;
	}//end getBoard
	
	public int getP() {
		return p;
	}//end getP
	
	public void setModelListener( ModelListener modelListener ) {
		this.modelListener = modelListener;
	}//end setModelListener

	@Override
	public void number(int p) throws IOException {
		this.p = p;
		modelListener.number(p);
	}//end number

	@Override
	public void name(int p, String n) throws IOException {
		modelListener.name(p, n);
	}//end name

	@Override
	public void turn(int p) throws IOException {
		modelListener.turn(p);
	}//end turn

	@Override
	public void add(int p, int r, int c) throws IOException {
		board.setSpot(r, c, p);
		modelListener.add(p, r, c);
	}//end add

	@Override
	public void clear() throws IOException {
		board.clear();
		modelListener.clear();
	}//end clear
	
	public void close() {}
}//end C4ModelClone
