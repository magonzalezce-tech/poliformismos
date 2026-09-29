package service;

import Interfaces.EstadoPedido;
import model.Pedido;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Repartidor implements Runnable {
    private String nombre;
    private ZonaDeCarga zonaDeCarga;
    private Random random = new Random();
    private List<Pedido> listaPedidos;

    public Repartidor(String nombre) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
        this.listaPedidos = new ArrayList<>();
    }

    public void asignarPedido(Pedido pedido) {
        this.listaPedidos.add(pedido);
    }

    @Override
    public void run() {
        System.out.println("▶ Repartidor " + nombre + " está activo en la zona de carga.");
        while (true) {
            Pedido pedido = zonaDeCarga.retirarPedido();

            if (pedido == null) {

                break;
            }

            System.out.println("🚚 " + nombre + " RETIRÓ el Pedido #" + pedido.getId() + " con estado: " + pedido.getEstado());

            try {

                int tiempoSimulacion = 1500 + random.nextInt(1500);
                Thread.sleep(tiempoSimulacion);
            } catch (InterruptedException e) {
                System.out.println("⚠ Repartidor " + nombre + " fue interrumpido.");
                Thread.currentThread().interrupt();
                break;
            }

            pedido.setEstado(EstadoPedido.ENTREGADO);
            System.out.println("✅ " + nombre + " ENTREGÓ el Pedido #" + pedido.getId() + " en " + pedido.getDireccionEntrega() + ".");
        }
        System.out.println("🏁 Repartidor " + nombre + " ha finalizado, no quedan más envíos.");
    }
}