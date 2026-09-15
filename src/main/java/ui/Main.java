package ui;

import model.Pedido;
import model.PedidoComida;
import service.Repartidor;
import service.ZonaDeCarga;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SPEEDFAST ===\n");

        ZonaDeCarga zonaComun = new ZonaDeCarga();

        zonaComun.agregarPedido(new PedidoComida("COM-101", "Av. Del Mar 450", 3.5));
        zonaComun.agregarPedido(new PedidoComida("COM-102", "Calle Los Alerces 92", 6.0));
        zonaComun.agregarPedido(new PedidoComida("ENC-201", "Oficina Central Torre B", 12.0));
        zonaComun.agregarPedido(new PedidoComida("EXP-301", "Condominio El Rosal Dep. 402", 2.1));
        zonaComun.agregarPedido(new PedidoComida("EXP-302", "Farmacia Cruz Verde Centro", 1.5));
        zonaComun.agregarPedido(new PedidoComida("ENC-202", "Pasaje Las Violetas 771", 8.4));


        List<Pedido> pedidosCarlos = new ArrayList<>();
        pedidosCarlos.add(new PedidoComida("COM-101", "Av. Del Mar 450", 3.5));
        pedidosCarlos.add(new PedidoComida("COM-102", "Calle Los Alerces 92", 6.0));

        List<Pedido> pedidosAna = new ArrayList<>();
        pedidosAna.add(new PedidoComida("ENC-201", "Oficina Central Torre B", 12.0));
        pedidosAna.add(new PedidoComida("EXP-301", "Condominio El Rosal Dep. 402", 2.1));

        List<Pedido> pedidosLuis = new ArrayList<>();
        pedidosLuis.add(new PedidoComida("EXP-302", "Farmacia Cruz Verde Centro", 1.5));
        pedidosLuis.add(new PedidoComida("ENC-202", "Pasaje Las Violetas 771", 8.4));


        Repartidor r1 = new Repartidor("Carlos", zonaComun);
        Repartidor r2 = new Repartidor("Ana", zonaComun);
        Repartidor r3 = new Repartidor("Luis", zonaComun);

        ExecutorService ejecutor = Executors.newFixedThreadPool(3);


        ejecutor.execute(r1);
        ejecutor.execute(r2);
        ejecutor.execute(r3);


        ejecutor.shutdown();

        try {

            if (ejecutor.awaitTermination(10, TimeUnit.MINUTES)) {
                System.out.println("\n=======================================================");
                System.out.println("🎉 Todos los pedidos han sido entregados correctamente.");
                System.out.println("=======================================================");
            }
        } catch (InterruptedException e) {
            System.err.println("No se han entregado todos los pedidos.");
            Thread.currentThread().interrupt();
        }
    }
}