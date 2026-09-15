package Interfaces;

import model.Pedido;

public interface Cancelable {
    void cancelar(Pedido pedido, String motivo);

    void cancelar();
}