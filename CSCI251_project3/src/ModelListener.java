/**
 * ModelListener.java
 * 
 * @author	Derek Brown
 *
 * Purpose:	Interface that receives notifications from the model
 */

import java.io.IOException;

public interface ModelListener {
	
	public void number( int p ) throws IOException;
	
	public void name( int p, String n ) throws IOException;
	
	public void turn( int p ) throws IOException;
	
	public void add( int p, int r, int c ) throws IOException;
	
	public void clear() throws IOException;
	
}//end ModelListener
