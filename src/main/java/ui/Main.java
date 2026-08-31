package ui;

import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;
import model.ControladorDeEnvios;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA INTEGRAL SPEEDFAST ===\n");


        ControladorDeEnvios controlador = new ControladorDeEnvios();


        Pedido pedidoComida = new PedidoComida("COM-901", "Av. Alemania 320", 3.5);
        Pedido pedidoEncomienda = new PedidoEncomienda("ENC-902", "Parque Industrial Bodega 4", 15.0);
        Pedido pedidoExpress = new PedidoExpress("EXP-903", "Farmacia Central Local 5", 6.8);


        pedidoComida.mostrarResumen();
        System.out.println("Tiempo estimado: " + pedidoComida.calcularTiempoEntrega() + " min.");
        pedidoComida.asignarRepartidor();
        controlador.despachar(pedidoComida);


        pedidoEncomienda.mostrarResumen();
        System.out.println("Tiempo estimado: " + pedidoEncomienda.calcularTiempoEntrega() + " min.");
        pedidoEncomienda.asignarRepartidor("Juan Pérez");
        controlador.cancelar(pedidoEncomienda, "El empaque no cumple con las normas de seguridad.");


        pedidoExpress.mostrarResumen();
        System.out.println("Tiempo estimado: " + pedidoExpress.calcularTiempoEntrega() + " min.");
        pedidoExpress.asignarRepartidor("María López");
        controlador.despachar(pedidoExpress);


        controlador.verHistorial();
    }
}