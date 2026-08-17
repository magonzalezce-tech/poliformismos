package com.speedfast;

public class Pedido {
    
    protected String idPedido;
    protected String direccionEntrega;
    protected String tipoPedido;

 
    public Pedido(String idPedido, String direccionEntrega, String tipoPedido) {
     
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.tipoPedido = tipoPedido;
    }

  
    public void asignarRepartidor() {
        System.out.println("[" + idPedido + "] Buscando repartidor para entrega en: " + direccionEntrega);
    }

   
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("[" + idPedido + "] Asignando manualmente al repartidor: " + nombreRepartidor);
    }

    public void assignarRepartidor(String carlosGómez) {
    }
}