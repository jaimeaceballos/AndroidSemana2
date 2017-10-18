package com.example.jaime.formulariodedatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VerificacionActivity extends AppCompatActivity {

    private TextView nombre, fecha_nacimiento,telefono,email,descripcion;
    private Button editar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificacion);

        Bundle bundle = getIntent().getExtras();

        nombre              = (TextView) findViewById(R.id.tv_nombre);
        fecha_nacimiento    = (TextView) findViewById(R.id.tv_fecha_nacimiento_valor);
        telefono            = (TextView) findViewById(R.id.tv_telefono_valor);
        email               = (TextView) findViewById(R.id.tv_email_valor);
        descripcion         = (TextView) findViewById(R.id.tv_descripcion_valor);
        editar              = (Button) findViewById(R.id.btn_volver);
        
        nombre.setText(bundle.getString("NOMBRE"));
        fecha_nacimiento.setText(bundle.getString("FECHA_NACIMIENTO"));
        telefono.setText(bundle.getString("TELEFONO"));
        email.setText(bundle.getString("EMAIL"));
        descripcion.setText(bundle.getString("DESCRIPCION"));

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    @Override
    public  void onBackPressed(){
        super.onBackPressed();
    }
}
