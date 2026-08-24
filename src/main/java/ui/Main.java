package ui;

import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

public class Main {
    public static void main(String[] args) {

        Pedido pedido1 = new PedidoComida("COM-101", "Av. del Sol 456", 4.5);
        Pedido pedido2 = new PedidoEncomienda("ENC-202", "Calle Los Almendros 789", 10.0);
        Pedido pedido3 = new PedidoExpress("EXP-303", "Pasaje Central 123", 6.0);


        Pedido[] listaPedidos = {pedido1, pedido2, pedido3};

        System.out.println("=== SISTEMA DE REPARTO SPEEDFAST ===");

        for (Pedido p : listaPedidos) {

            p.mostrarResumen();


            System.out.println("Tiempo estimado de entrega: " + p.calcularTiempoEntrega() + " minutos.");


            p.asignarRepartidor();


            p.asignarRepartidor("Carlos Repartidor");
        }
        System.out.println("========================================");
    }
}