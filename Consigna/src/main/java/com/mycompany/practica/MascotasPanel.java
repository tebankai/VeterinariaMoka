/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.practica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MascotasPanel extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;
    
   

    public MascotasPanel() {
        setLayout(new BorderLayout());

        // Crear y configurar el modelo de la tabla
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Dueño");
        tableModel.addColumn("Observaciones");
        tableModel.addColumn("Ranking");
        tableModel.addColumn("Foto");

        // Inicializar la tabla con el modelo
        table = new JTable(tableModel);
        jScrollPane1 = new JScrollPane(table);

        // Panel superior con campos de entrada
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        
         Dimension fixedSize = new Dimension(100, 15);  // Tamaño de 200x25 píxeles para los campos de texto
        txtnombremasco = new JTextField();
        txtnombremasco.setPreferredSize(fixedSize);
        txtdueno = new JTextField();
        txtdueno.setPreferredSize(fixedSize);
        txtobservaciones = new JTextField();
        txtobservaciones.setPreferredSize(fixedSize);
        txtranking = new JTextField();
        txtranking.setPreferredSize(fixedSize);
       
        
        txtnombremasco = new JTextField();
        txtdueno = new JTextField();
        txtobservaciones = new JTextField();
        txtranking = new JTextField();

        inputPanel.add(new JLabel("Nombre:"));
        inputPanel.add(txtnombremasco);
        inputPanel.add(new JLabel("Dueño:"));
        inputPanel.add(txtdueno);
        inputPanel.add(new JLabel("Observaciones:"));
        inputPanel.add(txtobservaciones);
        inputPanel.add(new JLabel("Ranking:"));
        inputPanel.add(txtranking);
        inputPanel.add(new JLabel("Foto:"));

        // Componente para mostrar la foto (en este caso solo la etiqueta)
        lblFoto = new JLabel("Foto de la mascota", JLabel.CENTER);
        lblFoto.setPreferredSize(new Dimension(50, 50)); // Tamaño de la etiqueta
        lblFoto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        inputPanel.add(lblFoto);

        // Botón para agregar datos
        agregar = new JButton("Agregar Mascota");
        agregar.addActionListener(this::agregarMascota);

        // Botón para eliminar todas las filas de la tabla
        eliminar = new JButton("Eliminar todo");
        eliminar.addActionListener(this::eliminarTodo);

        // Panel inferior para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(agregar);
        buttonPanel.add(eliminar);

        // Crear panel principal y agregar componentes
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(jScrollPane1, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);
    }

    /**
     * Método para agregar una mascota a la tabla
     */
    private void agregarMascota(ActionEvent e) {
        // Obtener datos de los campos
        String nombre = txtnombremasco.getText();
        String dueno = txtdueno.getText();
        String observaciones = txtobservaciones.getText();
        String ranking = txtranking.getText();

        // Validar que los campos no estén vacíos
        if (nombre.isEmpty() || dueno.isEmpty() || observaciones.isEmpty() || ranking.isEmpty()  ) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Agregar los datos al modelo de la tabla
        tableModel.addRow(new Object[]{nombre, dueno, observaciones, ranking});

        // Limpiar los campos
        txtnombremasco.setText("");
        txtdueno.setText("");
        txtobservaciones.setText("");
        txtranking.setText("");
        lblFoto.setText("Foto cargada");
    }

    /**
     * Método para eliminar todas las filas de la tabla
     */
    private void eliminarTodo(ActionEvent e) {
        // Confirmar la eliminación
        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar todas las mascotas?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            tableModel.setRowCount(0); // Eliminar todas las filas
        }
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtnombremasco = new javax.swing.JTextField();
        txtdueno = new javax.swing.JTextField();
        txtobservaciones = new javax.swing.JTextField();
        txtranking = new javax.swing.JTextField();
        agregar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblFoto = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        txtnombremasco.setText("Nombre");

        txtdueno.setText("Dueño");

        txtobservaciones.setText("Observaciones");

        txtranking.setText("Ranking");

        agregar.setText("Agregar");

        eliminar.setText("Eliminar");

        lblFoto.setText("Foto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(agregar)
                .addGap(18, 18, 18)
                .addComponent(eliminar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnombremasco)
                            .addComponent(txtdueno)
                            .addComponent(txtobservaciones, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(txtranking))
                        .addGap(94, 94, 94)
                        .addComponent(lblFoto)))
                .addContainerGap(286, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombremasco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFoto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtdueno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtobservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(txtranking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar)
                    .addComponent(eliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JButton eliminar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JTextField txtdueno;
    private javax.swing.JTextField txtnombremasco;
    private javax.swing.JTextField txtobservaciones;
    private javax.swing.JTextField txtranking;
    // End of variables declaration//GEN-END:variables
}
