package com.example.punto1sueldo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Impresion extends AppCompatActivity {

    private TextView impreNombre;
    private TextView impreApellidos;
    private TextView impreFechaN;
    private TextView impreFechaIngre;
    private TextView impreSueldoB;
    private TextView impreHorasT;
    private TextView impreHorasE;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impresion);
        casteo();
        impresionPantalla();
    }
    private void casteo() {
        impreNombre = (TextView) findViewById(R.id.tvImpreNombre);
        impreApellidos = (TextView) findViewById(R.id.tvImpreApell);
        impreFechaN = (TextView) findViewById(R.id.tvImpreFechaNa);
        impreFechaIngre = (TextView) findViewById(R.id.tvImprFechaIngre) ;
        impreSueldoB = (TextView) findViewById(R.id.tvImprSueldoB) ;
        impreHorasT = (TextView) findViewById(R.id.tvImpreHorasT);
        impreHorasE = (TextView) findViewById(R.id.tvImpreHorasE);
    }

    private void impresionPantalla() {
        Trabajador trabajador = getIntent().getParcelableExtra("trabajador");
        impreNombre.setText("Nombre: "+trabajador.getNombre());
        impreApellidos.setText("Apellidos: "+trabajador.getApellidos());
        impreFechaN.setText(" Fecha Nacimiento: "+trabajador.getFechaNa());
        impreFechaIngre.setText("Fecha ingreso: "+ trabajador.getFechaIngr());
        impreHorasT.setText("Horas trabajadas: " +trabajador.getHorasTra());
        impreHorasE.setText("Horas Extra: "+ trabajador.getHorasExt());
        impreSueldoB.setText("Sueldo base: "+ trabajador.getSueldoB());
    }
    public void regresar(View view) {
        Intent main = new Intent (this, MainActivity.class);
        startActivity(main);
    }
}