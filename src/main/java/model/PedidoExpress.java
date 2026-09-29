package model;

public class PedidoExpress extends Pedido {

    public PedidoExpress(String idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm, Double.parseDouble("Compra Express"));
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Pedido [" + getIdPedido() + "]: Geolocalizando repartidor más cercano con disponibilidad inmediata...");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("✓ Pedido " + getIdPedido() + " asignado a " + nombreRepartidor + " por proximidad de urgencia.");
    }

    @Override
    public int calcularTiempoEntrega() {
        int tiempoBase = 10;
        return getDistanciaKm() > 5 ? tiempoBase + 5 : tiempoBase;
    }

    @Override
    public void cancelar(Pedido pedido, String motivo) {

    }

    @Override
    public void despachar(Pedido pedido) {

    }
}