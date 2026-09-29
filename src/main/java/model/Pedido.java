package model;

import Interfaces.Cancelable;
import Interfaces.Despachable;
import Interfaces.EstadoPedido;
import Interfaces.Rastreable;

public abstract class Pedido implements Despachable, Cancelable, Rastreable {
    private int idPedido;
    private String direccionEntrega;
    private String tipoPedido;
    private double distanciaKm;
    private EstadoPedido estado;

    public Pedido(int id, String direccionEntrega, String tipoPedido, double distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.tipoPedido = tipoPedido;
        this.distanciaKm = distanciaKm;
        this.estado = EstadoPedido.PENDIENTE;
    }


    public int getId() { return idPedido; }
    public String getDireccionEntrega() { return direccionEntrega; }
    public String getTipoPedido() { return tipoPedido; }
    public double getDistanciaKm() { return distanciaKm; }
    public EstadoPedido getEstado() { return estado; }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }


    public void mostrarResumen() {
        System.out.println("[" + tipoPedido + "] ID: " + idPedido + " | Destino: " + direccionEntrega + " | Distancia: " + distanciaKm + " km | Estado: " + estado);
    }


    public abstract void asignarRepartidor();
    public abstract void asignarRepartidor(String nombreRepartidor);


    public abstract int calcularTiempoEntrega();

    @Override
    public String toString() {
        return "Pedido #" + idPedido + " [" + tipoPedido + "] - Destino: " + direccionEntrega + " (" + estado + ")";
    }


    @Override
    public void despachar() {
        this.estado = EstadoPedido.valueOf("En Camino");
        System.out.println("➔ Pedido " + idPedido + " ha cambiado su estado a EN CAMINO.");
    }

    @Override
    public void cancelar() {
        this.estado = EstadoPedido.valueOf("Cancelado");
        System.out.println("❌ Pedido " + idPedido + " ha sido CANCELADO.");
    }

    @Override
    public void verHistorial() {
        System.out.println("📋 Historial " + idPedido + ": Creado -> Asignado -> " + estado);
    }

    public void setResult(String entregado) {
    }

    public String getIdPedido() {
        return "";
    }
}
