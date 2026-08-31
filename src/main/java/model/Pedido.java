package model;

public abstract class Pedido {
    protected String idPedido;
    protected String direccionEntrega;
    protected double distanciaKm;
    protected String tipoPedido;
    protected String estado;

    public Pedido(String idPedido, String direccionEntrega, double distanciaKm, String tipoPedido) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
        this.tipoPedido = tipoPedido;
        this.estado = "Creado";
    }

    public void mostrarResumen() {
        System.out.println("----------------------------------------");
        System.out.println("ID Pedido: " + idPedido + " [" + tipoPedido + "]");
        System.out.println("Dirección: " + direccionEntrega + " | Distancia: " + distanciaKm + " km");
        System.out.println("Estado Actual: " + estado);
    }


    public String getIdPedido() { return idPedido; }
    public void setEstado(String estado) { this.estado = estado; }


    public abstract int calcularTiempoEntrega();
    public abstract void asignarRepartidor();
    public abstract void asignarRepartidor(String nombreRepartidor);
}