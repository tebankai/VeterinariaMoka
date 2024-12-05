package com.mycompany.practica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ReservacionesPanel extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField txtNombreCliente, txtFecha, txtHora, txtObservaciones;
    private JButton btnAgregar, btnEliminar;
    private JScrollPane scrollTabla;

    public ReservacionesPanel() {
        setLayout(new BorderLayout()); // Usamos BorderLayout en lugar de GroupLayout

        // Crear y configurar el modelo de la tabla
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nombre Cliente");
        tableModel.addColumn("Fecha De Entrada");
        tableModel.addColumn("Fecha de Salida");
        tableModel.addColumn("Observaciones");

        // Inicializar la tabla con el modelo
        table = new JTable(tableModel);
        scrollTabla = new JScrollPane(table);  // Inicializamos correctamente el JScrollPane

        // Panel superior con campos de entrada
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));

        // Establecer tamaño fijo para los campos de texto
        Dimension fixedSize = new Dimension(100, 25);  // Tamaño ajustado a 100x25 píxeles
        txtNombreCliente = new JTextField();
        txtNombreCliente.setPreferredSize(fixedSize);
        txtFecha = new JTextField();
        txtFecha.setPreferredSize(fixedSize);
        txtHora = new JTextField();
        txtHora.setPreferredSize(fixedSize);
        txtObservaciones = new JTextField();
        txtObservaciones.setPreferredSize(fixedSize);

        // Agregar los campos y etiquetas al panel
        inputPanel.add(new JLabel("Nombre Cliente:"));
        inputPanel.add(txtNombreCliente);
        inputPanel.add(new JLabel("Fecha De Entrada:"));
        inputPanel.add(txtFecha);
        inputPanel.add(new JLabel("Fecha de Salida:"));
        inputPanel.add(txtHora);
        inputPanel.add(new JLabel("Observaciones:"));
        inputPanel.add(txtObservaciones);

        // Botón para agregar datos
        btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(this::agregarInformacion);

        // Botón para eliminar todas las filas de la tabla
        btnEliminar = new JButton("Eliminar todo");
        btnEliminar.addActionListener(this::eliminarTodo);

        // Panel inferior para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAgregar);
        buttonPanel.add(btnEliminar);

        // Crear el panel principal y agregar componentes
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH); // Campos de entrada arriba
        mainPanel.add(scrollTabla, BorderLayout.CENTER); // La tabla en el centro
        mainPanel.add(buttonPanel, BorderLayout.SOUTH); // Los botones en la parte inferior

        // Agregar el panel principal al panel actual
        add(mainPanel, BorderLayout.CENTER);
    }

    /**
     * Método para agregar una fila a la tabla con la información de la reservación
     */
    private void agregarInformacion(ActionEvent e) {
        // Obtener datos de los campos
        String nombreCliente = txtNombreCliente.getText();
        String fecha = txtFecha.getText();
        String hora = txtHora.getText();
        String observaciones = txtObservaciones.getText();

        // Validar que los campos no estén vacíos
        if (nombreCliente.isEmpty() || fecha.isEmpty() || hora.isEmpty() || observaciones.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Agregar los datos al modelo de la tabla
        tableModel.addRow(new Object[]{nombreCliente, fecha, hora, observaciones});

        // Limpiar los campos
        txtNombreCliente.setText("");
        txtFecha.setText("");
        txtHora.setText("");
        txtObservaciones.setText("");
    }

    /**
     * Método para eliminar todas las filas de la tabla
     */
    private void eliminarTodo(ActionEvent e) {
        // Confirmar la eliminación
        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar toda la información?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            tableModel.setRowCount(0); // Eliminar todas las filas
        }
    }

 

   
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombreMascota = new javax.swing.JTextField();
        fechaentrada = new javax.swing.JTextField();
        fechasalida = new javax.swing.JTextField();
        emilinar = new javax.swing.JButton();
        agregar = new javax.swing.JButton();
        reservacionesTabla = new javax.swing.JScrollPane();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(600, 400));

        nombreMascota.setText("Nombre Mascota");

        fechaentrada.setText("Fecha de Entrada");

        fechasalida.setText("Fecha de Salida");

        emilinar.setText("Eliminar Todo");

        agregar.setText("Agregar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(agregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(emilinar))
                    .addComponent(nombreMascota)
                    .addComponent(fechaentrada)
                    .addComponent(fechasalida))
                .addGap(46, 46, 46)
                .addComponent(reservacionesTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(247, 247, 247))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nombreMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(fechaentrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(reservacionesTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(fechasalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emilinar)
                    .addComponent(agregar))
                .addContainerGap(144, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JButton emilinar;
    private javax.swing.JTextField fechaentrada;
    private javax.swing.JTextField fechasalida;
    private javax.swing.JTextField nombreMascota;
    private javax.swing.JScrollPane reservacionesTabla;
    // End of variables declaration//GEN-END:variables
}
