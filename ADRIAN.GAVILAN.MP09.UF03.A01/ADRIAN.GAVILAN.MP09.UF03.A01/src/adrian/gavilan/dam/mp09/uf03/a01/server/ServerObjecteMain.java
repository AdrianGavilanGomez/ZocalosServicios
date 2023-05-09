package adrian.gavilan.dam.mp09.uf03.a01.server;

import java.io.IOException;

public class ServerObjecteMain {

	public static void main(String[] args) {
		
		try {
			new ServerObjecte().procesar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
