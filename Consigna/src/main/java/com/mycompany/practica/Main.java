package com.mycompany.practica;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
//  * //Esta es para usar con joptionpane, poner como main para usar las ventanas

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static ArrayList<Mascota> mascotas = new ArrayList<>();
    static ArrayList<Cita> citas = new ArrayList<>();
    static ArrayList<Reservacion> reservaciones = new ArrayList<>();

    public static void main(String[] args) throws CedulaInvalidaException {
        String[] opciones = {"Registrar Usuario", "Registrar Mascota", "Registrar Cita", "Registrar Reservación", "Listar Usuarios", "Listar Mascotas", "Salir"};
        int opcion;

        do {
            opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Menú Principal",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            switch (opcion) {
                case 0 -> registrarUsuario();
                case 1 -> registrarMascota();
                case 2 -> registrarCita();
                case 3 -> registrarReservacion();
                case 4 -> listarUsuarios();
                case 5 -> listarMascotas();
                case 6 -> JOptionPane.showMessageDialog(null, "¡Gracias por usar el sistema!");
                default -> JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        } while (opcion != 6);
    }

    // Métodos para manejar usuarios, mascotas, citas y reservaciones
    private static void registrarUsuario() throws CedulaInvalidaException {
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del usuario:");
        for (Usuario usuario : usuarios) {
            if (usuario.getCedula().equals(cedula)) {
                JOptionPane.showMessageDialog(null, "El usuario ya existe.");
                return;
            }
        }

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre completo:");
        String telefono = JOptionPane.showInputDialog("Ingrese el teléfono:");
        String direccion = JOptionPane.showInputDialog("Ingrese la dirección:");
        String[] roles = {"Doctor", "Secretaria"};
        String rol = (String) JOptionPane.showInputDialog(null, "Seleccione el rol:", "Rol",
                JOptionPane.QUESTION_MESSAGE, null, roles, roles[0]);
        boolean estado = JOptionPane.showConfirmDialog(null, "¿El usuario está activo?", "Estado",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

        Usuario nuevoUsuario = new Usuario(cedula, nombre, telefono, direccion, estado, rol);
        usuarios.add(nuevoUsuario);

        JOptionPane.showMessageDialog(null, "Usuario registrado con éxito.");
    }

    private static void registrarMascota() {
        String nombreMascota = JOptionPane.showInputDialog("Ingrese el nombre de la mascota:");
        for (Mascota mascota : mascotas) {
            if (mascota.getNombre().equals(nombreMascota)) {
                JOptionPane.showMessageDialog(null, "La mascota ya existe.");
                return;
            }
        }

        String cedulaDuenio = JOptionPane.showInputDialog("Ingrese la cédula del dueño:");
        Usuario duenio = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getCedula().equals(cedulaDuenio)) {
                duenio = usuario;
                break;
            }
        }

        if (duenio == null) {
            JOptionPane.showMessageDialog(null, "El dueño no está registrado.");
            return;
        }

        String observaciones = JOptionPane.showInputDialog("Ingrese observaciones sobre la mascota:");
        String[] rankings = {"1 estrella", "2 estrellas", "3 estrellas"};
        String ranking = (String) JOptionPane.showInputDialog(null, "Seleccione el ranking de la mascota:", "Ranking",
                JOptionPane.QUESTION_MESSAGE, null, rankings, rankings[0]);

        Mascota nuevaMascota = new Mascota(nombreMascota, duenio, observaciones, ranking);
        mascotas.add(nuevaMascota);

        JOptionPane.showMessageDialog(null, "Mascota registrada con éxito.");
    }

    private static void listarUsuarios() {
        if (usuarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay usuarios registrados.");
        } else {
            StringBuilder listaUsuarios = new StringBuilder("Usuarios registrados:\n");
            for (Usuario usuario : usuarios) {
                listaUsuarios.append(usuario).append("\n");
            }
            JOptionPane.showMessageDialog(null, listaUsuarios.toString());
        }
    }

    private static void listarMascotas() {
        if (mascotas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay mascotas registradas.");
        } else {
            StringBuilder listaMascotas = new StringBuilder("Mascotas registradas:\n");
            for (Mascota mascota : mascotas) {
                listaMascotas.append(mascota).append("\n");
            }
            JOptionPane.showMessageDialog(null, listaMascotas.toString());
        }
    }

    private static void registrarCita() {
        String nombreMascota = JOptionPane.showInputDialog("Ingrese el nombre de la mascota:");
        Mascota mascota = null;
        for (Mascota m : mascotas) {
            if (m.getNombre().equals(nombreMascota)) {
                mascota = m;
                break;
            }
        }

        if (mascota == null) {
            JOptionPane.showMessageDialog(null, "La mascota no está registrada.");
            return;
        }

        String fecha = JOptionPane.showInputDialog("Ingrese la fecha de la cita (YYYY-MM-DD):");
        String hora = JOptionPane.showInputDialog("Ingrese la hora de la cita (HH:MM):");
        String observaciones = JOptionPane.showInputDialog("Ingrese observaciones para la cita:");

        Cita nuevaCita = new Cita(nombreMascota, fecha, hora, observaciones);
        citas.add(nuevaCita);

        JOptionPane.showMessageDialog(null, "Cita registrada con éxito.");
    }

    private static void registrarReservacion() {
        String nombreMascota = JOptionPane.showInputDialog("Ingrese el nombre de la mascota:");
        Mascota mascota = null;
        for (Mascota m : mascotas) {
            if (m.getNombre().equals(nombreMascota)) {
                mascota = m;
                break;
            }
        }

        if (mascota == null) {
            JOptionPane.showMessageDialog(null, "La mascota no está registrada.");
            return;
        }

        String fechaEntrada = JOptionPane.showInputDialog("Ingrese la fecha de entrada (YYYY-MM-DD):");
        String fechaSalida = JOptionPane.showInputDialog("Ingrese la fecha de salida (YYYY-MM-DD):");

        Reservacion nuevaReservacion = new Reservacion(nombreMascota, fechaEntrada, fechaSalida);
        reservaciones.add(nuevaReservacion);

        JOptionPane.showMessageDialog(null, "Reservación registrada con éxito.");
    }
}



