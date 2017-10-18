package com.example.jaime.formulariodedatos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText nombre,fechaNacimiento,telefono,email,descripcion;
    private Button siguiente;
    private int anio,mes,dia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre          = (EditText) findViewById(R.id.et_nombre);
        fechaNacimiento = (EditText) findViewById(R.id.et_fecha_nacimiento);
        telefono        = (EditText) findViewById(R.id.et_telefono);
        email           = (EditText) findViewById(R.id.et_email);
        descripcion     = (EditText) findViewById(R.id.et_descripcion);
        siguiente       = (Button) findViewById(R.id.btn_siguiente);

        fechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setDate();
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),VerificacionActivity.class);
                intent.putExtra("NOMBRE",nombre.getText().toString());
                intent.putExtra("FECHA_NACIMIENTO",fechaNacimiento.getText().toString());
                intent.putExtra("TELEFONO",telefono.getText().toString());
                intent.putExtra("EMAIL",email.getText().toString());
                intent.putExtra("DESCRIPCION",descripcion.getText().toString());
                startActivity(intent);
            }
        });
    }

    @SuppressWarnings("deprecation")
    public void setDate(){
        showDialog(999);
    }

    @SuppressWarnings("deprecation")
    @Override
    protected Dialog onCreateDialog(int id){
        if(id == 999){
            DatePickerDialog datePicker = new DatePickerDialog(this,myDateListener,anio,mes,dia);
            datePicker.setTitle("Fecha de Nacimiento");
            return datePicker;
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int anio, int mes, int dia) {
            showDate(anio,mes+1,dia);
        }
    };

    private void showDate(int anio,int mes,int dia){
        fechaNacimiento.setText(new StringBuilder().append(dia).append("/").append(mes).append("/").append(anio));
    }
}
