package org.example.app;

import org.example.cardapio.*;
import org.example.pedido.GerenciadorPedidos;
import org.example.pedido.Pedido;

import java.util.Collection;

public class RestauranteFacade {

    private GerenciadorPedidos gerenciador = new GerenciadorPedidos();

    public Pedido criarPedido(String nomeCliente){
        return gerenciador.criarPedido(nomeCliente);
    }

    private Lanche criarLanche(int opcao){
        switch (opcao){
            case 1: return LancheFactory.xBurger();
            case 2: return LancheFactory.xSalada();
            case 3: return LancheFactory.xBacon();
            default: return null;
        }
    }

    public boolean adicionarItem(Pedido pedido, int opcaoLanche, boolean cheddar, boolean baconExtra) {
        Lanche lanche = criarLanche(opcaoLanche);
        if (lanche == null) {
            return false;
        }

        ItemCardapio item = lanche;

        if (cheddar) {
            item = new ComCheddar(item);
        }
        if (baconExtra) {
            item = new ComBaconExtra(item);
        }

        pedido.adicionarItem(item);
        return true;
    }

    public Collection<Pedido> getPedidos(){
        return gerenciador.getPedidos();
    }

    public  double calcularTotalDoDia(){
        return gerenciador.calcularTotalDoDia();
    }
}
