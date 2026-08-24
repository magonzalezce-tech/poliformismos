package model;

public class PedidoEncomienda extends Pedido {

    public PedidoEncomienda(String idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm, "Encomienda (Documentos/Paquetes)");
    }

    @Override
    public int calcularTiempoEntrega() {

        return (int) (20 + (1.5 * distanciaKm));
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("[Asignación Automática] Reteniendo " + idPedido + " hasta validar peso y embalaje.");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("[Asignación Manual] " + nombreRepartidor + " asignado. Recuerde VALIDAR peso y embalaje en mesón.");
    }
}