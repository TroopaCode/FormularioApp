package com.troopacode.formularioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {


    TextView tvNombre, tvFecha, tvTelefono, tvEmail, tvDescripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        Bundle extras=  getIntent().getExtras();
        tvNombre =(TextView) findViewById(R.id.textViewNombre);
        tvFecha =(TextView) findViewById(R.id.textViewFecha);
        tvTelefono =(TextView) findViewById(R.id.textViewTelefono);
        tvEmail =(TextView) findViewById(R.id.textViewEmail);
        tvDescripcion =(TextView) findViewById(R.id.textViewDescripcion);

        tvNombre.setText(extras.getString(getResources().getString(R.string.nombre)));
        tvFecha.setText(extras.getString(getResources().getString(R.string.fecha)));
        tvTelefono.setText(extras.getString(getResources().getString(R.string.telefono)));
        tvEmail.setText(extras.getString(getResources().getString(R.string.email)));
        tvDescripcion.setText(extras.getString(getResources().getString(R.string.descripcion)));
    }

    public void EditarDatos(View view)
    {
        /*Intent intentEditar = new Intent(ConfirmarDatos.this, MainActivity.class);
        intentEditar.putExtra(getResources().getString(R.string.nombre), tvNombre.getText().toString());
        //intentEditar.putExtra(getResources().getString(R.string.fecha), tvFecha.getText().toString());
        intentEditar.putExtra(getResources().getString(R.string.telefono), tvTelefono.getText().toString());
        intentEditar.putExtra(getResources().getString(R.string.email), tvEmail.getText().toString());
        intentEditar.putExtra(getResources().getString(R.string.descripcion), tvDescripcion.getText().toString());
        startActivity(intentEditar);
        finish();
*/
        Intent intentSiguiente = new Intent(ConfirmarDatos.this, MainActivity.class);
        intentSiguiente.putExtra(getResources().getString(R.string.nombre), tvNombre.getText().toString());
        intentSiguiente.putExtra(getResources().getString(R.string.fecha), tvFecha.getText().toString());
        intentSiguiente.putExtra(getResources().getString(R.string.telefono), tvTelefono.getText().toString());
        intentSiguiente.putExtra(getResources().getString(R.string.email), tvEmail.getText().toString());
        intentSiguiente.putExtra(getResources().getString(R.string.descripcion), tvDescripcion.getText().toString());
        startActivity(intentSiguiente);
    }
}