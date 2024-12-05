/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica;

/**
 *
 * @author tebankai;
 */
public class Mascota {
    private String nombre;
    private Usuario duenio; // Asociado a un objeto Usuario
    private String observaciones;
    private String ranking; // Puede ser "1 estrella", "2 estrellas", "3 estrellas"

    // Constructor por defecto
    public Mascota() {}

    // Constructor con parámetros
    public Mascota(String nombre, Usuario duenio, String observaciones, String ranking) {
        this.nombre = nombre;
        this.duenio = duenio;
        this.observaciones = observaciones;
        this.ranking = ranking;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getDuenio() {
        return duenio;
    }

    public void setDuenio(Usuario duenio) {
        this.duenio = duenio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    // Método toString
    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", duenio=" + duenio.getNombre() +
                ", observaciones='" + observaciones + '\'' +
                ", ranking='" + ranking + '\'' +
                '}';
    }
}

