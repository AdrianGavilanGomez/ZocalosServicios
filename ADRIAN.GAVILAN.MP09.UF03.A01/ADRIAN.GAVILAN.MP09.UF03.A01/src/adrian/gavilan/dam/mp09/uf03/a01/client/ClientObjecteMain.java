package adrian.gavilan.dam.mp09.uf03.a01.client;

import java.io.IOException;
import java.net.UnknownHostException;

public class ClientObjecteMain {

	public static void main(String[] args) {
		
		try {
			new ClientObjecte().procesar();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
