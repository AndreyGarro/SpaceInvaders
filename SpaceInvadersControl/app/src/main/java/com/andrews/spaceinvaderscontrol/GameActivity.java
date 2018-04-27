package com.andrews.spaceinvaderscontrol;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import static java.lang.Integer.parseInt;

public class GameActivity extends AppCompatActivity {
    private SensorManager sensorManager;
    private Sensor sensor;
    private SensorEventListener sensorEventListener;
    private TextView txtActual, txtSiguiente, txtPuntaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        txtActual = (TextView) findViewById(R.id.txtActual);
        txtPuntaje = (TextView) findViewById(R.id.txtPuntaje);
        txtSiguiente = (TextView) findViewById(R.id.txtSiguiente);

        final String direccionIP = getIntent().getStringExtra("dirIP");
        final int port = getIntent().getIntExtra("port", 0);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float x = event.values[1];
                if (x < -2) { //movimiento a la derecha
                    final SocketCliente socketCliente = new SocketCliente(direccionIP, port);
                    socketCliente.valor = "1";
                    socketCliente.execute();
                } else if (x > 2) { //movimimento a la izquierda
                    final SocketCliente socketCliente = new SocketCliente(direccionIP, port);
                    socketCliente.valor = "2";
                    socketCliente.execute();
                }
                else{
                    final SocketCliente socketCliente = new SocketCliente(direccionIP, port);
                    socketCliente.valor = "0";
                    socketCliente.execute();
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        start();
    }

    private void start() {
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    private void stop(){
        sensorManager.unregisterListener(sensorEventListener);
    }
}
