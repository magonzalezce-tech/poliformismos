package service;

import model.Pedido;
import java.util.ArrayList;
import java.util.List;

public class ZonaDeCarga {

    private List<Pedido> listaPedidos = new ArrayList<>();


    public synchronized void agregarPedido(Pedido p) {
        listaPedidos.add(p);
    }


    public synchronized Pedido retirarPedido() {
        if (!listaPedidos.isEmpty()) {

            return listaPedidos.remove(0);
        }
        return null;
    }
}