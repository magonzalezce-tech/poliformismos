package com.speedfast;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE REPARTO SPEEDFAST ===\n");


        com.speedfast.Pedido pedido1 = new com.speedfast.PedidoComida("COM-101", "Av. Alemania 450");
        com.speedfast.Pedido pedido2 = new com.speedfast.PedidoEncomienda("ENC-202", "Calle Los Alerces 890");
        com.speedfast.Pedido pedido3 = new com.speedfast.PedidoExpress("EXP-303", "Pasaje El Sol 12");


        List<com.speedfast.Pedido> listaPedidos = new ArrayList<>();
        listaPedidos.add(pedido1);
        listaPedidos.add(pedido2);
        listaPedidos.add(pedido3);

        System.out.println("--- 1. Asignacion Automatica ---");
        for (com.speedfast.Pedido p : listaPedidos) {
            p.asignarRepartidor();
        }

        System.out.println("\n--- 2. Asignacion Manual ---");
        pedido1.asignarRepartidor("Carlos Gómez");
        pedido2.asignarRepartidor("Ana Martínez");
        pedido3.asignarRepartidor("Pedro Soto");
    }
}