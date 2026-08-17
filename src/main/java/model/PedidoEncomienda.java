package com.speedfast;

public class PedidoEncomienda extends com.speedfast.Pedido {

    public PedidoEncomienda(String idPedido, String direccionEntrega) {
        super(idPedido, direccionEntrega, "Encomienda");
    }


    @Override
    public void asignarRepartidor() {
        System.out.println("[" + idPedido + "] Sistema en espera de validación de PESO y EMBALAJE seguro.");
    }


    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("[" + idPedido + "] ENCOMIENDA MANUAL: " + nombreRepartidor + " asignado. Validación: Peso verificado y embalaje listo.");
    }
}