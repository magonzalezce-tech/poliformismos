package service;

import Interfaces.Cancelable;
import Interfaces.Despachable;
import Interfaces.EstadoPedido;
import Interfaces.Rastreable;
import model.Pedido;

import java.util.ArrayList;

public class ControladorDeEnvios implements Despachable, Cancelable, Rastreable {

    private ArrayList<String> historialEntregas;

    public ControladorDeEnvios() {
        this.historialEntregas = new ArrayList<>();
    }

    @Override
    public void despachar(Pedido pedido) {
        pedido.setEstado(EstadoPedido.valueOf("En Camino"));
        String registro = "Pedido " + pedido.getIdPedido() + " despachado con éxito hacia " + pedido.getDireccionEntrega();
        historialEntregas.add(registro);
        System.out.println(">> [DESPACHO] " + registro);
    }

    @Override
    public void cancelar(Pedido pedido, String motivo) {
        pedido.setEstado(EstadoPedido.valueOf("Cancelado"));
        String registro = "Pedido " + pedido.getIdPedido() + " CANCELADO. Motivo: " + motivo;
        historialEntregas.add(registro);
        System.out.println(">> [ALERTA] " + registro);
    }

    @Override
    public void verHistorial() {
        System.out.println("\n===== HISTORIAL DE ENTREGAS Y OPERACIONES =====");
        if (historialEntregas.isEmpty()) {
            System.out.println("No hay registros en el historial.");
        } else {
            for (String registro : historialEntregas) {
                System.out.println("- " + registro);
            }
        }
        System.out.println("===============================================");
    }

    @Override
    public void cancelar() {

    }

    @Override
    public void despachar() {

    }
}