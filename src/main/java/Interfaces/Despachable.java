package Interfaces;

import model.Pedido;

public interface Despachable {
    void despachar(Pedido pedido);

    void despachar();
}
