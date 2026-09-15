package service;

import model.Pedido;
import java.util.Random;

public class Repartidor implements Runnable {
    private String nombre;
    private ZonaDeCarga zonaDeCarga;
    private Random random = new Random();

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    @Override
    public void run() {
        System.out.println(">> Repartidor [" + nombre + "] ha entrado a trabajar.");

        while (true) {

            Pedido pedido = zonaDeCarga.retirarPedido();


            if (pedido == null) {
                break;
            }


            System.out.println("🚚 [" + nombre + "] Retiró el Pedido #" + pedido.getId() +
                    " | Estado: " + pedido.getEstado() +
                    " | Destino: " + pedido.getDireccionEntrega());

            try {

                int tiempoEspera = 1500 + random.nextInt(1500);
                Thread.sleep(tiempoEspera);


                pedido.setEstado("ENTREGADO");


                System.out.println("✔ [" + nombre + "] ¡Pedido #" + pedido.getId() +
                        " ENTREGADO! - Status: " + pedido.getEstado() +
                        " - Tiempo de entrega estimado: " + pedido.calcularTiempoEntrega() + " mins.");

            } catch (InterruptedException e) {
                System.err.println("❌ [" + nombre + "] Fue interrumpido durante la entrega del Pedido #" + pedido.getId());
                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println("<< Repartidor [" + nombre + "] finalizó su jornada (Zona de carga vacía).");
    }
}