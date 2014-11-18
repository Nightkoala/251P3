/**
 * ConnectFour.java
 * 
 * @author	Derek Brown <djb3718@rit.edu>
 * 
 * Purpose:	Client program for network connect four
 */

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ConnectFour{

	public static void usage() {
		System.err.println("Usage: java ConnectFour <host> <port> <playername>");
		System.exit(1);
	}//end usage
	
	public static void main( String[] args ) throws IOException {
		if( args.length != 3 ) {
			usage();
		}//end if
		String host = args[0];
		int port;
		try {
			port = Integer.parseInt( args[1] );
		} catch( NumberFormatException e ) {
			System.err.printf("<port> must be an int\n");
			e.printStackTrace(System.err);
		}//end try/catch
		port = Integer.parseInt( args[1] );
		String playerName = args[2];
		
		Socket socket = new Socket();
		socket.connect( new InetSocketAddress( host, port ) );
		
		//model
		C4ModelClone model = new C4ModelClone();
		//view
		C4UI view = new C4UI( model.getBoard(), playerName );
		//proxy
		ModelProxy proxy = new ModelProxy( socket );
		//model.setModelListener
		model.setModelListener( view );
		//view.setViewlistener
		view.setViewListener( proxy );
		//proxy.setModelListener
		proxy.setModelListener( model );
		//proxy.join
		proxy.join( playerName );
		
	}//end main
}//end ConnectFour
