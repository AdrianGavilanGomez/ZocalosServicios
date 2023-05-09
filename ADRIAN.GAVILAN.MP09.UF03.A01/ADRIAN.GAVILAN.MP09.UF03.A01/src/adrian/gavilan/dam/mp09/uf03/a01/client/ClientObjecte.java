package adrian.gavilan.dam.mp09.uf03.a01.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import adrian.gavilan.dam.mp09.uf03.a01.config.Settings;
import adrian.gavilan.dam.mp09.uf03.a01.domain.Llibre;



public class ClientObjecte {

	private Socket clienteSocket;

	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;

	public void procesar() throws UnknownHostException, IOException, ClassNotFoundException {
		clienteSocket = new Socket(Settings.IP, Settings.PORT);

		// =====================
		System.out.println("Esperando la transmisión del servidor ...");
		objectInputStream = new ObjectInputStream(clienteSocket.getInputStream());
		Llibre llibreServidor = (Llibre) objectInputStream.readObject();
		System.out.println("Hemos recibido del servidor: " + llibreServidor.toString());
		// =====================
		llibreServidor = this.getLlibre(llibreServidor);
		System.out.println("Vamos a enviar al servidor el llibre recibido con algunas modificaciones: "
				+ llibreServidor.toString());
		objectOutputStream = new ObjectOutputStream(clienteSocket.getOutputStream());
		objectOutputStream.writeObject(llibreServidor);
		// =====================
		System.out.println("Nos desconectamos ...");
		objectOutputStream.close();
		objectInputStream.close();
		clienteSocket.close();

	}

	private Llibre getLlibre(Llibre llibre) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduzca el title: ");
		llibre.setTitle(scanner.next());
		System.out.println("Introduzca el autor: ");
		llibre.setAutor(scanner.next());
	
		scanner.close();

		return llibre;
	}

}
