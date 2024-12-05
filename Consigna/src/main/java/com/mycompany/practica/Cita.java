/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica;

/**
 *
 * @author tebankai;
 */
public class Cita {
    private String nombreMascota;
    private String fecha; // Formato: YYYY-MM-DD
    private String hora; // Formato: HH:MM
    private String observaciones;

    // Constructor por defecto
    public Cita() {}

    // Constructor con parámetros
    public Cita(String nombreMascota, String fecha, String hora, String observaciones) {
        this.nombreMascota = nombreMascota;
        this.fecha = fecha;
        this.hora = hora;
        this.observaciones = observaciones;
    }

    // Getters y Setters
    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    // Método toString
    @Override
    public String toString() {
        return "Cita{" +
                "nombreMascota='" + nombreMascota + '\'' +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }
}
