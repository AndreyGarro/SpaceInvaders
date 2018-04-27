package com.andrews.spaceinvaderscontrol;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    private EditText direccionIP, puerto;
    private Button btnAceptar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        direccionIP = (EditText) findViewById(R.id.txtDireccionIP);
        puerto = (EditText) findViewById(R.id.txtPuerto);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int puerto1 = parseInt(puerto.getText().toString());
                String direccion = direccionIP.getText().toString();

                Intent x = new Intent(MainActivity.this, GameActivity.class);
                x.putExtra("dirIP", direccion);
                x.putExtra("port", puerto1);
                startActivity(x);
            }
        });

    }

    private void conectar(View view) {

    }
}

