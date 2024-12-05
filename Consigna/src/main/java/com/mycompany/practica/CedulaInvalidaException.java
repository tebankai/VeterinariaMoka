/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica;
// Excepción personalizada para cédula inválida

class CedulaInvalidaException extends Exception {
    public CedulaInvalidaException(String mensaje) {
        super(mensaje);
    }
}
