package com.andrews.spaceinvaderscontrol;


import android.os.AsyncTask;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;

public class SocketCliente extends AsyncTask<String, Void, String> {

    private String ipAddress;
    private int port;
    private Socket socket;
    private DataOutputStream dt;
    private DataInputStream ip;
    private PrintWriter pw;
    public String valor = " ";


    public SocketCliente(String ip, int port){
        this.ipAddress = ip;
        this.port = port;
    }

    @Override
    protected String doInBackground(String... strings) {
        try{
            socket = new Socket (ipAddress, port);
            pw = new PrintWriter(socket.getOutputStream());
            pw.write(valor);
            pw.flush();
            pw.close();
            socket.close();

        }catch (Exception e){

        }
        return null;
    }
}