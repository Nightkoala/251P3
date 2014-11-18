
import java.io.IOException;

public interface ViewListener {

	public void join( String n ) throws IOException;
	
	public void add( int p, int c ) throws IOException;
	
	public void clear() throws IOException;
	
}//end ViewListener
