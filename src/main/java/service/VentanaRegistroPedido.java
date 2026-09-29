package service;

import model.Pedido;
import javax.swing.*;
import java.awt.*;

public class VentanaRegistroPedido extends JFrame {
    public VentanaRegistroPedido(ZonaDeCarga zona) {
        setTitle("Registrar Pedido");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 5, 5));

        JLabel lblId = new JLabel(" ID Pedido (Numérico):");
        JTextField txtId = new JTextField();

        JLabel lblDireccion = new JLabel(" Dirección Entrega:");
        JTextField txtDireccion = new JTextField();

        JLabel lblTipo = new JLabel(" Tipo de Servicio:");
        String[] opciones = {"Comida", "Encomienda", "Compra Express"};
        JComboBox<String> comboTipo = new JComboBox<>(opciones);

        JLabel lblDistancia = new JLabel(" Distancia (Km):");
        JTextField txtDistancia = new JTextField();

        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");

        btnGuardar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText().trim());
                String dir = txtDireccion.getText().trim();
                String tipo = (String) comboTipo.getSelectedItem();
                double dist = Double.parseDouble(txtDistancia.getText().trim());

                if (dir.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "La dirección no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Pedido nuevo = new Pedido(id, dir, tipo, dist);
                zona.agregarPedido(nuevo);

                JOptionPane.showMessageDialog(this, "Pedido registrado exitosamente.\n" + nuevo, "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Verifique los campos numéricos (ID y Distancia).", "Error de Formato", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnCancelar.addActionListener(e -> dispose());

        add(lblId); add(txtId);
        add(lblDireccion); add(txtDireccion);
        add(lblTipo); add(comboTipo);
        add(lblDistancia); add(txtDistancia);
        add(btnGuardar); add(btnCancelar);
    }
}