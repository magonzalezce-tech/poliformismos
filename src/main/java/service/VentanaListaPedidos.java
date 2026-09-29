package service;

import model.Pedido;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VentanaListaPedidos extends JFrame {
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private ZonaDeCarga zonaDeCarga;

    public VentanaListaPedidos(ZonaDeCarga zona) {
        this.zonaDeCarga = zona;
        setTitle("Listado de Envios Globales");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        String[] columnas = {"ID", "Tipo", "Dirección", "Distancia (Km)", "Estado"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modeloTabla);

        actualizarTabla();

        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);

        JButton btnRefrescar = new JButton("🔄 Actualizar Tabla");
        btnRefrescar.addActionListener(e -> actualizarTabla());
        add(btnRefrescar, BorderLayout.SOUTH);
    }

    private void actualizarTabla() {
        modeloTabla.setRowCount(0);
        List<Pedido> pedidos = zonaDeCarga.getTodosLosPedidos();
        for (Pedido p : pedidos) {
            Object[] fila = {
                    p.getId(),
                    p.getTipoPedido(),
                    p.getDireccionEntrega(),
                    p.getDistanciaKm(),
                    p.getEstado()
            };
            modeloTabla.addRow(fila);
        }
    }
}