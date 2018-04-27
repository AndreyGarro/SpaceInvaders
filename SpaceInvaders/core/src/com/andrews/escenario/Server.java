package com.andrews.escenario;

import java.net.*;
import java.io.*;

public class Server implements Runnable {
	private static Server instance;
	private ServerSocket server;
	private Socket socket;
	private int puerto = 5555;
	private ObjectOutputStream salida;
	private InputStreamReader entrada;
	private static boolean exist = false;
	private String recibido = "0";
	private BufferedReader a;

	private Server() {
		new Thread(this).start();
	}

	public static Server getInstance() {
		if (instance == null) {
			exist = true;
			instance = new Server();
		}
		return instance;
	}
	
	public static boolean getExist() {
		return exist;
	}


	public void run() {
		while (true) {
			try {
				server = new ServerSocket(puerto);
				socket = new Socket();
				socket = server.accept();
				entrada = new InputStreamReader(socket.getInputStream());
				a = new BufferedReader(entrada);
				recibido = a.readLine();
				server.close();
				socket.close();
			} catch (Exception e) {

			}
		}
	}
	
	public String getRecibido() {
		return this.recibido;
	}
}