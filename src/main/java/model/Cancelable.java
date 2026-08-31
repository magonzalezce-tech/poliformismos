package model;

public interface Cancelable {
    void cancelar(Pedido pedido, String motivo);
}