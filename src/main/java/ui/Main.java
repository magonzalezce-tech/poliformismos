package ui;

import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;
import service.Repartidor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("=====================================================");
        System.out.println("         SPEEDFAST LOGISTIC SYSTEM       ");
        System.out.println("=====================================================\n");


        PedidoComida pComida1 = new PedidoComida("COM-101", "Av. Alemania 450", 3.2);
        PedidoComida pComida2 = new PedidoComida("COM-102", "Calle Bilbao 1280", 1.5);

        PedidoEncomienda pEncomienda1 = new PedidoEncomienda("ENC-201", "Edificio Las Heras Of. 4", 12.0, 4.5);
        PedidoEncomienda pEncomienda2 = new PedidoEncomienda("ENC-202", "Pasaje Los Alerces 55", 5.0, 18.2);

        PedidoExpress pExpress1 = new PedidoExpress("EXP-301", "Farmacia Cruz Local 3", 6.8);
        PedidoExpress pExpress2 = new PedidoExpress("EXP-302", "Supermercado Mayorista", 2.1);


        System.out.println("--- 📋 RESUMEN INICIAL Y PREVISIÓN DE TIEMPOS ---");
        pComida1.mostrarResumen();
        System.out.println("⏱ Tiempo estimado: " + pComida1.calcularTiempoEntrega() + " min.\n");

        pEncomienda1.mostrarResumen();
        System.out.println("⏱ Tiempo estimado: " + pEncomienda1.calcularTiempoEntrega() + " min.\n");

        pExpress1.mostrarResumen();
        System.out.println("⏱ Tiempo estimado: " + pExpress1.calcularTiempoEntrega() + " min.\n");


        System.out.println("--- 🎯 SIMULACIÓN DE ASIGNACIONES (POLIMORFISMO) ---");
        pComida1.asignarRepartidor(); // Sobrescrito Automático
        pComida1.asignarRepartidor("Carlos Gómez", true);
        System.out.println();


        System.out.println("--- ❌ PRUEBA DE FUNCIONALIDADES OPERATIVAS ---");
        pExpress2.mostrarResumen();
        pExpress2.cancelar();
        pExpress2.verHistorial();
        System.out.println();


        System.out.println("--- 🚀 ACTIVACIÓN DE REPARTIDORES EN PARALELO (CONCURRENCIA) ---");

        Repartidor repartidor1 = new Repartidor("Juan Pérez");
        Repartidor repartidor2 = new Repartidor("María Silva");
        Repartidor repartidor3 = new Repartidor("Pedro Soto");


        repartidor1.asignarPedido(pComida1);
        repartidor1.asignarPedido(pExpress1);

        repartidor2.asignarPedido(pEncomienda1);
        repartidor2.asignarPedido(pComida2);

        repartidor3.asignarPedido(pEncomienda2);


        ExecutorService ejecutor = Executors.newFixedThreadPool(3);


        ejecutor.execute(repartidor1);
        ejecutor.execute(repartidor2);
        ejecutor.execute(repartidor3);


        ejecutor.shutdown();

        try {

            if (ejecutor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("\n=====================================================");
                System.out.println("       TODAS LAS ENTREGAS CONCURRENTES TERMINADAS     ");
                System.out.println("=====================================================");
            }
        } catch (InterruptedException e) {
            System.out.println("La simulación global fue interrumpida.");
        }
    }
}