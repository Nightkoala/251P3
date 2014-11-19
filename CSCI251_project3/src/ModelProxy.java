
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ModelProxy implements ViewListener {

	// Hidden data members
	
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private ModelListener modelListener;
	
	// Constructor
	
	public ModelProxy( Socket socket ) throws IOException {
		this.socket = socket;
		out = new PrintWriter( socket.getOutputStream(), true );
		in = new BufferedReader(
				new InputStreamReader( socket.getInputStream() ) );
	}//end ModelProxy constructor
	
	// Methods
	
	public void setModelListener( ModelListener modelListener ) {
		this.modelListener = modelListener;
		new ReaderThread().start();
	}//end setModelListener
	
	@Override
	public void join(String n) throws IOException {
		out.printf("join %s\n", n);
	}//end join

	@Override
	public void add(int p, int c) throws IOException {
		out.printf("add %d %d\n", p, c );
	}//end add

	@Override
	public void clear() throws IOException {
		out.printf("clear\n");
	}//end clear
	
	// Hidden helper class
	
	private class ReaderThread extends Thread {
		public void run() {
			try {
				for( ;; ) {
					int p, r, c;
					String n;
					String cmd = in.readLine();
					switch( cmd.charAt(0) ) {
						case 'n':
							if( cmd.charAt(1) == 'u' ) {
								p = Character.getNumericValue( cmd.charAt( 7 ) );
								modelListener.number( p );
								break;
							}//end if
							p = Character.getNumericValue( cmd.charAt( 5 ) );
							n = cmd.substring( 7 );
							modelListener.name(p, n);
							break;
						case 't':
							p = Character.getNumericValue( cmd.charAt( 5 ) );
							modelListener.turn( p );
							break;
						case 'a':
							p = Character.getNumericValue( cmd.charAt( 4 ) );
							r = Character.getNumericValue( cmd.charAt( 6 ) );
							c = Character.getNumericValue( cmd.charAt( 8 ) );
							modelListener.add(p, r, c);
							break;
						case 'c':
							modelListener.clear();
							break;
						default:
							System.err.println("Bad message");
							break;
					}//end switch
				}//end for
			} catch( Exception e ) {
				modelListener.close();
			}//end try/catch
			finally {
				try {
					socket.close();
				} catch( IOException e ) {}//end try/catch
			}//end finally
		}//end run
	}//end ReaderThread class
}//end ModelProxy
