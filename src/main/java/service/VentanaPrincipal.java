package service;

import model.Pedido;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VentanaPrincipal extends JFrame {
    private ZonaDeCarga zonaDeCarga;

    public VentanaPrincipal() {
        this.zonaDeCarga = new ZonaDeCarga();


        zonaDeCarga.agregarPedido(new Pedido(101, "Av. Alemania 450", "Comida", 3.5));
        zonaDeCarga.agregarPedido(new Pedido(102, "Calle Bilbao 12", "Encomienda", 5.0));
        zonaDeCarga.agregarPedido(new Pedido(103, "Farmacia Central 4", "Compra Express", 1.2));
        zonaDeCarga.agregarPedido(new Pedido(104, "Pasaje Los Alerces", "Encomienda", 8.4));
        zonaDeCarga.agregarPedido(new Pedido(105, "Supermercado Express", "Compra Express", 2.0));

        setTitle("SpeedFast Logistics - Panel de Control");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 10, 10));

        JButton btnRegistrar = new JButton("📝 Registrar Nuevo Pedido");
        JButton btnListar = new JButton("📋 Ver Tabla de Pedidos");
        JButton btnSimular = new JButton("🚀 Iniciar Simulación Concurrente");

        btnRegistrar.addActionListener(e -> new VentanaRegistroPedido(zonaDeCarga).setVisible(true));
        btnListar.addActionListener(e -> new VentanaListaPedidos(zonaDeCarga).setVisible(true));

        btnSimular.addActionListener(e -> {
            btnSimular.setEnabled(false);

            new Thread(() -> {
                ExecutorService ejecutor = Executors.newFixedThreadPool(3);
                ejecutor.execute(new Repartidor("Juan Pérez"));
                ejecutor.execute(new Repartidor("María Silva"));
                ejecutor.execute(new Repartidor("Pedro Soto"));

                ejecutor.shutdown();
                try {
                    if (ejecutor.awaitTermination(1, TimeUnit.MINUTES)) {
                        JOptionPane.showMessageDialog(this,
                                "Todos los pedidos han sido entregados correctamente",
                                "Simulación Terminada", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                btnSimular.setEnabled(true);
            }).start();
        });

        add(btnRegistrar);
        add(btnListar);
        add(btnSimular);
    }
}