package adrian.gavilan.dam.mp09.uf03.a01.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import adrian.gavilan.dam.mp09.uf03.a01.config.Settings;
import adrian.gavilan.dam.mp09.uf03.a01.domain.Llibre;



public class ServerObjecte {

	private ServerSocket serverSocket;
	private Socket clienteSocket;

	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;

	public void procesar() throws IOException, ClassNotFoundException {
		serverSocket = new ServerSocket(Settings.PORT);

		while (true) {
			System.out.println("Esperando conexiones  de clientes ...");
			clienteSocket = serverSocket.accept();

			System.out.println("Cliente conectado");

			// ========================
			Llibre llibreServidor = this.getLlibre();
			System.out.println("S: Enviamos este llibre al cliente: " + llibreServidor.toString());
			// ========================
			objectOutputStream = new ObjectOutputStream(clienteSocket.getOutputStream());
			objectOutputStream.writeObject(llibreServidor);
			// =============================================
			System.out.println("Esperando a que el cliente transmita ....");
			objectInputStream = new ObjectInputStream(clienteSocket.getInputStream());
			// Quedamos a la espera de que el cliente transmita
			Llibre llibreCliente = (Llibre) objectInputStream.readObject();
			System.out.println("Hemos recibido del cliente: " + llibreCliente.toString());
			// =============================================
			System.out.println("Procedemos a desconectar al cliente");
			objectOutputStream.close();
			objectInputStream.close();
			clienteSocket.close();

		}
	}

	private Llibre getLlibre() {
		Llibre llibre = new Llibre();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduzca el title: ");
		llibre.setTitle(scanner.next());
		System.out.println("Introduzca el autor: ");
		llibre.setAutor(scanner.next());
		
		scanner.close();

		return llibre;
	}

}
