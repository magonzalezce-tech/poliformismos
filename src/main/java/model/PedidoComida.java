package com.speedfast;

public class PedidoComida extends com.speedfast.Pedido {

    public PedidoComida(String idPedido, String direccionEntrega) {
        super(idPedido, direccionEntrega, "Comida");
    }


    @Override
    public void asignarRepartidor() {
        System.out.println("[" + idPedido + "] Buscando repartidor con MOCHILA TÉRMICA..");
    }


    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("[" + idPedido + "] COMIDA MANUAL: " + nombreRepartidor + " asignado. Se encontro repartidor con MOCHILA TÉRMICA.");
    }
}