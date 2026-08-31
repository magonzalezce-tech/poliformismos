package model;

public class PedidoComida extends Pedido {

    public PedidoComida(String idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm, "Comida");
    }

    @Override
    public int calcularTiempoEntrega() {
        return (int) (15 + (2 * distanciaKm));
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("[" + idPedido + "] Buscando repartidor con mochila térmica disponible...");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("[" + idPedido + "] Asignado manualmente a: " + nombreRepartidor + " (Verificado: Cuenta con mochila térmica).");
    }
}