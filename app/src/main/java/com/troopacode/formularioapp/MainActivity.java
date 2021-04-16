package com.troopacode.formularioapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    TextInputEditText tiTelefono, tiNombre, tiCorreo, tiDescripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalendarView calendario = (CalendarView) findViewById(R.id.fecha);

        tiNombre = (TextInputEditText) findViewById(R.id.nombre);
        tiTelefono = (TextInputEditText) findViewById(R.id.numero);
        tiCorreo = (TextInputEditText) findViewById(R.id.correo);
        tiDescripcion = (TextInputEditText) findViewById(R.id.descripcion);

        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                fechaCalendario= dayOfMonth+"/"+ (month+1)+"/"+year;
                Toast.makeText(MainActivity.this, fechaCalendario, Toast.LENGTH_SHORT).show();

            }
        });

        try {
            Bundle extras= getIntent().getExtras();
            tiNombre.setText(extras.getString(getResources().getString(R.string.nombre)));

            fechaCalendario=extras.getString(getResources().getString(R.string.fecha));
            calendario.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(fechaCalendario).getTime(), true, true);

            tiTelefono.setText(extras.getString(getResources().getString(R.string.telefono)));
            tiCorreo.setText(extras.getString(getResources().getString(R.string.email)));
            tiDescripcion.setText(extras.getString(getResources().getString(R.string.descripcion)));

        }
        catch  (Exception e)
        { //NullPointerException

            Toast.makeText(MainActivity.this, "Sin elementos", Toast.LENGTH_SHORT).show();
        }

    }

    String fechaCalendario;
    public void enviarDatos(View view)
    {


        Intent intentSiguiente = new Intent(MainActivity.this, ConfirmarDatos.class);
        intentSiguiente.putExtra(getResources().getString(R.string.nombre), tiNombre.getText().toString());
        intentSiguiente.putExtra(getResources().getString(R.string.fecha), fechaCalendario);
        intentSiguiente.putExtra(getResources().getString(R.string.telefono), tiTelefono.getText().toString());
        intentSiguiente.putExtra(getResources().getString(R.string.email), tiCorreo.getText().toString());
        intentSiguiente.putExtra(getResources().getString(R.string.descripcion), tiDescripcion.getText().toString());
        startActivity(intentSiguiente);
        finish();
    }
}