package com.example.punto1sueldo;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    Calendar myCalendar = Calendar.getInstance();
    private EditText nombre;
    private EditText apellidos;
    private EditText fechaNacimiento;
    private EditText fechaIngreso;
    private EditText sueldoBase;
    private EditText horasExtra;
    private EditText horasTrabajadas;
    private TextView sueldoMe;
    private TextView edadText;
    private  Button btnEdad;
    Date fechaActual = new Date(); //Objeto de tipo fecha
    int yearActual = 0;
    int mesAct = 0;
    int yearA = 0,mes =0 ,dia = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        casteo();
        fechaNacimiento = (EditText) findViewById(R.id.etFechaNa);
        fechaNacimiento.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
            Calendar myCalendar = Calendar.getInstance();
            yearA = myCalendar.get(Calendar.YEAR);
            mes = myCalendar.get(Calendar.MONTH);
            int dia = myCalendar.get(Calendar.DAY_OF_MONTH);
            //SE crea el objeto DatePicker Dialog

            DatePickerDialog escogerFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    fechaNacimiento.setText(dayOfMonth + "/" + (month + 1) + "/" + year); //Para que en la parte del campo aparezca que se escribio la fecha
                    final int mesActual = month + 1; //Los meses empiezan desde 0
                    String diaFormat = (dayOfMonth < 10) ? "0" + String.valueOf(dayOfMonth) : String.valueOf(dayOfMonth);
                    String mesFormat = (mesActual < 10) ? "0" + String.valueOf(mesActual) :
                            String.valueOf(mesActual);
                    yearActual = year;
                    mesAct = Integer.parseInt(mesFormat);
                }
            }, yearA, mes, dia);
            escogerFecha.show();



    }

        public String calcularEdad ( int yearN, int mesN, int yearActual, int mesAct){
            int años = 0;
            int meses = 0;
            if (mesAct <= mesN) {
                años = yearN - yearActual;
                meses = mesN - mesAct;
            } else {
                años = yearN - yearActual - 1;
                meses = 12 - (mesAct - mesN);
            }
            return "Edad  " + años+ " años " + meses +" meses ";

        }
        public void botonEdad(View view) {
            edadText.setText(calcularEdad(yearA, (mes + 1), yearActual, mesAct));
        }


    public void casteo () {
        nombre = (EditText) findViewById(R.id.etNombre);
        apellidos = (EditText) findViewById(R.id.etApellidos);
        fechaIngreso = (EditText) findViewById(R.id.etIngreso);
        sueldoBase = (EditText) findViewById(R.id.etSueldo);
        btnEdad = (Button) findViewById(R.id.btnCalculoEdad);
        horasExtra = (EditText) findViewById(R.id.etHorasExtra);
        horasTrabajadas = (EditText) findViewById(R.id.etHorasTra);
        sueldoMe = (TextView) findViewById(R.id.tvSueldoM);
        edadText = (TextView) findViewById(R.id.tvEdad);
    }
    
    public void imprimir(View view) {
    String nombreT = nombre.getText().toString();
    String apellidosT = apellidos.getText().toString();
    String fechaNa = fechaNacimiento.getText().toString();
    String fechaIngr = fechaIngreso.getText().toString();
    double sueldoB = Double.parseDouble(sueldoBase.getText().toString());
    int horasTbj = Integer.parseInt(horasTrabajadas.getText().toString());
    int horasEx = Integer.parseInt(horasExtra.getText().toString());
    //Ejemplificar
    Trabajador trabajador = new Trabajador( nombreT,apellidosT,fechaNa,fechaIngr,sueldoB, horasTbj, horasEx );
        Intent intent = new Intent(MainActivity.this, Impresion.class);
        intent.putExtra("trabajador", trabajador);
        startActivity(intent);
    }


    public void sueldoMensual(View view) {
        int horasT = Integer.parseInt(horasTrabajadas.getText().toString());
        double sBase = Double.parseDouble(sueldoBase.getText().toString());
        int horasE = Integer.parseInt(horasExtra.getText().toString());
        if( horasT >= 48 ) { //Debe trabajar mas de 48 horas
            double porcSueldo = (sBase*0.02);
            double calculoSueldo = porcSueldo * horasE; // Puesto que se debe multiplicar de acuerdo a cada hora extra que estuvo trabajando
            double totalSueldo = calculoSueldo + sBase;
            sueldoMe.setText(""+ totalSueldo);
        }
        else {
            sueldoMe.setText("" + "Para horas extra trabaje mas de 48h " +sBase);
        }
    }

}