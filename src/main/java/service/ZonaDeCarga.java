package service;

import Interfaces.EstadoPedido;
import model.Pedido;
import java.util.ArrayList;
import java.util.List;

public class ZonaDeCarga {
    private final List<Pedido> listaPedidos = new ArrayList<>();

    public synchronized void agregarPedido(Pedido p) {
        listaPedidos.add(p);
    }

    public synchronized Pedido retirarPedido() {
        for (Pedido p : listaPedidos) {
            if (p.getEstado() == EstadoPedido.PENDIENTE) {

                p.setEstado(EstadoPedido.EN_REPARTO);
                return p;
            }
        }
        return null;
    }

    public synchronized List<Pedido> getTodosLosPedidos() {
        return new ArrayList<>(listaPedidos);
    }
}
