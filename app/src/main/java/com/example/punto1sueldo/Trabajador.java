package com.example.punto1sueldo;

import android.os.Parcel;
import android.os.Parcelable;

public class Trabajador implements Parcelable {
    private String nombre;
    private String apellidos;
    private String fechaNa;
    private String fechaIngr;
    private double sueldoB;
    private int horasTra;
    private int horasExt;

    public Trabajador(String nombre, String apellidos, String fechaNa, String fechaIngr, double sueldoB, int horasTra, int horasExt) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNa = fechaNa;
        this.fechaIngr = fechaIngr;
        this.sueldoB = sueldoB;
        this.horasTra = horasTra;
        this.horasExt = horasExt;

    }

    protected Trabajador(Parcel in) {
        nombre = in.readString();
        apellidos = in.readString();
        fechaNa = in.readString();
        fechaIngr = in.readString();
        sueldoB = in.readDouble();
        horasTra = in.readInt();
        horasExt = in.readInt();
    }

    public static final Creator<Trabajador> CREATOR = new Creator<Trabajador>() {
        @Override
        public Trabajador createFromParcel(Parcel in) {
            return new Trabajador(in);
        }

        @Override
        public Trabajador[] newArray(int size) {
            return new Trabajador[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNa() {
        return fechaNa;
    }

    public void setFechaNa(String fechaNa) {
        this.fechaNa = fechaNa;
    }

    public String getFechaIngr() {
        return fechaIngr;
    }

    public void setFechaIngr(String fechaIngr) {
        this.fechaIngr = fechaIngr;
    }

    public double getSueldoB() {
        return sueldoB;
    }

    public void setSueldoB(double sueldoB) {
        this.sueldoB = sueldoB;
    }

    public int getHorasTra() {
        return horasTra;
    }

    public void setHorasTra(int horasTra) {
        this.horasTra = horasTra;
    }

    public int getHorasExt() {
        return horasExt;
    }

    public void setHorasExt(int horasExt) {
        this.horasExt = horasExt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(apellidos);
        dest.writeString(fechaNa);
        dest.writeString(fechaIngr);
        dest.writeDouble(sueldoB);
        dest.writeInt(horasTra);
        dest.writeInt(horasExt);
    }
}
