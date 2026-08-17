package com.speedfast;

public class PedidoExpress extends com.speedfast.Pedido {

    public PedidoExpress(String idPedido, String direccionEntrega) {
        super(idPedido, direccionEntrega, "Compra Express");
    }


    @Override
    public void asignarRepartidor() {
        System.out.println("[" + idPedido + "] Localizando al repartidor MÁS CERCANO con DISPONIBILIDAD INMEDIATA.");
    }


    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("[" + idPedido + "] EXPRESS MANUAL: " + nombreRepartidor + " asignado. Validación: Confirmado repartidor disponible.");
    }
}