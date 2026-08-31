package model;

public class PedidoExpress extends Pedido {

    public PedidoExpress(String idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm, "Compra Express");
    }

    @Override
    public int calcularTiempoEntrega() {
        return distanciaKm > 5 ? 15 : 10;
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("[" + idPedido + "] Localizando al repartidor express más cercano con disponibilidad inmediata.");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("[" + idPedido + "] Asignación prioritaria a " + nombreRepartidor + " por cercanía inmediata.");
    }
}