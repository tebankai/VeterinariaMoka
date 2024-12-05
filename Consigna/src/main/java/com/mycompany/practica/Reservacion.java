/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica;

/**
 *
 * @author tebankai;
 */
public class Reservacion {
    private String nombreMascota;
    private String fechaEntrada; // Formato: YYYY-MM-DD
    private String fechaSalida; // Formato: YYYY-MM-DD

    // Constructor por defecto
    public Reservacion() {}

    // Constructor con parámetros
    public Reservacion(String nombreMascota, String fechaEntrada, String fechaSalida) {
        this.nombreMascota = nombreMascota;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    // Getters y Setters
    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    // Método toString
    @Override
    public String toString() {
        return "Reservacion{" +
                "nombreMascota='" + nombreMascota + '\'' +
                ", fechaEntrada='" + fechaEntrada + '\'' +
                ", fechaSalida='" + fechaSalida + '\'' +
                '}';
    }
}
