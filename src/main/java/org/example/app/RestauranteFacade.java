package org.example.app;

import org.example.cardapio.*;
import org.example.pedido.GerenciadorPedidos;
import org.example.pedido.Pedido;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class RestauranteFacade {

    private GerenciadorPedidos gerenciador = new GerenciadorPedidos();

    public Pedido criarPedido(String nomeCliente){
        return gerenciador.criarPedido(nomeCliente);
    }

    public Lanche criarLanche(int opcao){
        switch (opcao){
            case 1: return LancheFactory.xBurger();
            case 2: return LancheFactory.xSalada();
            case 3: return LancheFactory.xBacon();
            default: return null;
        }
    }

    public void adicionarItem(Pedido pedido, Lanche lanche, boolean cheddar, boolean baconExtra) {
        ItemCardapio item = lanche;
        if (cheddar) {
            item = new ComCheddar(item);
        }
        if (baconExtra) {
            item = new ComBaconExtra(item);
        }
        pedido.adicionarItem(item);
    }

    public Collection<Pedido> getPedidos(){
        return gerenciador.getPedidos();
    }

    public  double calcularTotalDoDia(){
        return gerenciador.calcularTotalDoDia();
    }

    public Pedido buscarPedido(int numero) {
        return gerenciador.buscarPedido(numero);
    }

    public boolean cancelarPedido(int numero) {
        return gerenciador.cancelarPedido(numero);
    }

    public boolean removerItem(Pedido pedido, int numeroItem) {
        return pedido.removerItem(numeroItem - 1);
    }

    public HashSet<String> getCombinacoes(){
        return gerenciador.getCombinacoes();
    }
}
