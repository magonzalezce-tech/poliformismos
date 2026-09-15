package model;

public class PedidoComida extends Pedido {

    public PedidoComida(String idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm, "Comida");
    }

    public PedidoComida(int i, String direccionEntrega) {
        super();
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

    @Override
    public void cancelar(Pedido pedido, String motivo) {

    }

    @Override
    public void despachar(Pedido pedido) {

    }
}