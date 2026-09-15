package model;

import Interfaces.Cancelable;
import Interfaces.Despachable;
import Interfaces.EstadoPedido;
import Interfaces.Rastreable;

public abstract class Pedido implements Despachable, Cancelable, Rastreable {
    protected int id;
    public String getOriginalEstado;
    protected String idPedido;
    public String direccionEntrega;
    protected double distanciaKm;
    protected String tipoPedido;
    protected EstadoPedido estado;

    public Pedido() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGetOriginalEstado() {
        return getOriginalEstado;
    }

    public void setGetOriginalEstado(String getOriginalEstado) {
        this.getOriginalEstado = getOriginalEstado;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public Pedido(String idPedido, String direccionEntrega, double distanciaKm, String tipoPedido) {
        this.id = id;
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
        this.tipoPedido = tipoPedido;
        this.estado = EstadoPedido.PENDIENTE;
    }

    public void mostrarResumen() {
        System.out.println("----------------------------------------");
        System.out.println("ID Pedido: " + idPedido + " [" + tipoPedido + "]");
        System.out.println("Dirección: " + direccionEntrega + " | Distancia: " + distanciaKm + " km");
        System.out.println("Estado Actual: " + estado);
    }


    public String getIdPedido() { return idPedido; }
    public void setEstado(EstadoPedido estado) { this.estado = estado; }

    public void setEstado(String nuevoEstado) {
        this.estado = EstadoPedido.valueOf(nuevoEstado.toUpperCase());
    }
    public abstract int calcularTiempoEntrega();
    public abstract void asignarRepartidor();
    public abstract void asignarRepartidor(String nombreRepartidor);

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", direccion='" + direccionEntrega + '\'' + ", estado=" + estado + '}';
    }
    
    @Override
    public void despachar() {
        System.out.println("Pedido " + idPedido + " ha sido despachado.");
    }

    @Override
    public void cancelar() {
        System.out.println("Pedido " + idPedido + " ha sido cancelado.");
    }

    @Override
    public void verHistorial() {
        System.out.println("Historial de auditoría para el Pedido " + idPedido);
    }

    public abstract void cancelar(Pedido pedido, String motivo);

    public abstract void despachar(Pedido pedido);
}

