package com.mycompany.practica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CitasPanel extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;
   

    public CitasPanel() {
        setLayout(new BorderLayout()); // Usamos BorderLayout en lugar de GroupLayout

        // Crear y configurar el modelo de la tabla
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Mascota");
        tableModel.addColumn("Fecha");
        tableModel.addColumn("Hora");
        tableModel.addColumn("Observaciones");

        // Inicializar la tabla con el modelo
        table = new JTable(tableModel);
        scrollTabla = new JScrollPane(table);  // Inicializamos correctamente el JScrollPane

        // Panel superior con campos de entrada
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));

        // Establecer tamaño fijo para los campos de texto
        Dimension fixedSize = new Dimension(100, 25);  // Tamaño ajustado a 100x25 píxeles
        txtMascota = new JTextField();
        txtMascota.setPreferredSize(fixedSize);
        txtFecha = new JTextField();
        txtFecha.setPreferredSize(fixedSize);
        txtHora = new JTextField();
        txtHora.setPreferredSize(fixedSize);
        txtObservaciones = new JTextField();
        txtObservaciones.setPreferredSize(fixedSize);

        // Agregar los campos y etiquetas al panel
        inputPanel.add(new JLabel("Mascota:"));
        inputPanel.add(txtMascota);
        inputPanel.add(new JLabel("Fecha:"));
        inputPanel.add(txtFecha);
        inputPanel.add(new JLabel("Hora:"));
        inputPanel.add(txtHora);
        inputPanel.add(new JLabel("Observaciones:"));
        inputPanel.add(txtObservaciones);

        // Botón para agregar datos
        btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(this::agregarInformacion);

        // Botón para eliminar todas las filas de la tabla
        btneliminar = new JButton("Eliminar todo");
        btneliminar.addActionListener(this::eliminarTodo);

        // Panel inferior para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAgregar);
        buttonPanel.add(btneliminar);

        // Crear el panel principal y agregar componentes
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH); // Campos de entrada arriba
        mainPanel.add(scrollTabla, BorderLayout.CENTER); // La tabla en el centro
        mainPanel.add(buttonPanel, BorderLayout.SOUTH); // Los botones en la parte inferior

        // Agregar el panel principal al panel actual
        add(mainPanel, BorderLayout.CENTER);
    }

    /**
     * Método para agregar una fila a la tabla con la información de la mascota
     */
    private void agregarInformacion(ActionEvent e) {
        // Obtener datos de los campos
        String mascota = txtMascota.getText();
        String fecha = txtFecha.getText();
        String hora = txtHora.getText();
        String observaciones = txtObservaciones.getText();

        // Validar que los campos no estén vacíos
        if (mascota.isEmpty() || fecha.isEmpty() || hora.isEmpty() || observaciones.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Agregar los datos al modelo de la tabla
        tableModel.addRow(new Object[]{mascota, fecha, hora, observaciones});

        // Limpiar los campos
        txtMascota.setText("");
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

        txtMascota = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        txtObservaciones = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        scrollTabla = new javax.swing.JScrollPane();

        setBackground(new java.awt.Color(255, 255, 255));

        txtMascota.setText("Nombre Mascota");

        txtFecha.setText("Fecha");

        txtHora.setText("Hora");

        txtObservaciones.setText("Observaciones");

        btnAgregar.setText("Agregar");

        btneliminar.setText("Eliminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(28, 28, 28)
                        .addComponent(btneliminar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtMascota, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtFecha, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtHora, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtObservaciones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(txtMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btneliminar))
                .addGap(33, 33, 33)
                .addComponent(scrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtMascota;
    private javax.swing.JTextField txtObservaciones;
    // End of variables declaration//GEN-END:variables
}
