package model;

public abstract class Pedido {

    protected String idPedido;
    protected String direccionEntrega;
    protected double distanciaKm;
    protected String tipoPedido;


    public Pedido(String idPedido, String direccionEntrega, double distanciaKm, String tipoPedido) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
        this.tipoPedido = tipoPedido;
    }


    public abstract int calcularTiempoEntrega();


    public void mostrarResumen() {
        System.out.println("========================================");
        System.out.println("ID Pedido: " + idPedido);
        System.out.println("Tipo: " + tipoPedido);
        System.out.println("Dirección: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
    }


    public void asignarRepartidor() {
        System.out.println("Buscando repartidor genérico para el pedido " + idPedido);
    }


    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Asignando manualmente al repartidor: " + nombreRepartidor);
    }
}