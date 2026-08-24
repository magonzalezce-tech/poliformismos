package model;

public class PedidoExpress extends Pedido {

    public PedidoExpress(String idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm, "Compra Express (Supermercado/Farmacia)");
    }

    @Override
    public int calcularTiempoEntrega() {

        int tiempo = 10;
        if (distanciaKm > 5) {
            tiempo += 5;
        }
        return tiempo;
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("[Asignación Automática] Buscando repartidor más CERCANO con DISPONIBILIDAD INMEDIATA para " + idPedido);
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("[Asignación Manual] " + nombreRepartidor + " asignado por cercanía para atención inmediata.");
    }
}