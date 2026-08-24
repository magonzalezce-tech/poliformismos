package model;

public class PedidoComida extends Pedido {

    public PedidoComida(String idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm, "Comida (Restaurante)");
    }

    @Override
    public int calcularTiempoEntrega() {

        return (int) (15 + (2 * distanciaKm));
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("[Asignación Automática] Buscando repartidor con MOCHILA TÉRMICA para " + idPedido);
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("[Asignación Manual] " + nombreRepartidor + " asignado. VERIFICAR que cuente con mochila térmica.");
    }
}