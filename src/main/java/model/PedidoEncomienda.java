package model;

public class PedidoEncomienda extends Pedido {

    public PedidoEncomienda(String idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm, "Encomienda");
    }

    @Override
    public int calcularTiempoEntrega() {
        return (int) (20 + (1.5 * distanciaKm));
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("[" + idPedido + "] Esperando validación de peso y embalaje para asignar repartidor automático.");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("[" + idPedido + "] Encomienda verificada. Asignada manualmente al repartidor: " + nombreRepartidor);
    }

    @Override
    public void cancelar(Pedido pedido, String motivo) {

    }

    @Override
    public void despachar(Pedido pedido) {

    }
}