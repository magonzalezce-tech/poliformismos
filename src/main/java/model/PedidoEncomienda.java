package model;

public class PedidoEncomienda extends Pedido {
    private double pesoKg;

    public PedidoEncomienda(String idPedido, String direccionEntrega, double distanciaKm, double pesoKg) {
        super(idPedido, direccionEntrega, distanciaKm, Double.parseDouble("Encomienda"));
        this.pesoKg = pesoKg;
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Pedido [" + getIdPedido() + "]: Validando peso (" + pesoKg + "kg) y dimensiones de embalaje...");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("✓ Pedido " + getIdPedido() + " asignado a " + nombreRepartidor + " tras validar peso de " + pesoKg + "kg.");
    }

    @Override
    public int calcularTiempoEntrega() {
        return (int) Math.round(20 + (1.5 * getDistanciaKm()));
    }

    @Override
    public void cancelar(Pedido pedido, String motivo) {

    }

    @Override
    public void despachar(Pedido pedido) {

    }
}