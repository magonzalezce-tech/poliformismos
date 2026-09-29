package model;

public class PedidoComida extends Pedido {

    public PedidoComida(String idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm, Double.parseDouble("Comida"));
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Pedido [" + getIdPedido() + "]: Buscando repartidor con MOCHILA TÉRMICA disponible...");
    }


    public void asignarRepartidor(String nombreRepartidor, boolean tieneMochila) {
        if (tieneMochila) {
            System.out.println("✓ Pedido " + getIdPedido() + " asignado a " + nombreRepartidor + " (Mochila validada).");
        } else {
            System.out.println("⚠ Alerta: " + nombreRepartidor + " no posee mochila térmica para el pedido " + getIdPedido());
        }
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        asignarRepartidor(nombreRepartidor, true);
    }

    @Override
    public int calcularTiempoEntrega() {
        return (int) (15 + (2 * getDistanciaKm()));
    }

    @Override
    public void cancelar(Pedido pedido, String motivo) {

    }

    @Override
    public void despachar(Pedido pedido) {

    }
}