/**
 * C4ModelClone.java
 * 
 * @author	Derek Brown
 *
 * Purpose
 */

public class C4ModelClone implements ModelListener {
	
	// Hidden Data Members
	
	private C4Board board = new C4Board();
	private ModelListener modelListener;
	
	// Constructor
	
	public C4ModelClone() {}
	
	// Methods
	
	public C4Board getBoard() {
		return board;
	}//end getBoard
	
	public void setModelListener( ModelListener modelListener ) {
		this.modelListener = modelListener;
	}//end setModelListener

	@Override
	public void number(int p) {

	}//end number

	@Override
	public void name(int p, String n) {

	}//end name

	@Override
	public void turn(int p) {

	}//end turn

	@Override
	public void add(int p, int r, int c) {

	}//end add

	@Override
	public void clear() {

	}//end clear
}//end C4ModelClone
