package org.example.app;

import org.example.cardapio.Lanche;
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
            case 1: return new Lanche("X-Burger", 16.0);
            case 2: return new Lanche("X-Salada", 18.0);
            case 3: return new Lanche("X-Bacon", 22.0);
            default: return null;
        }
    }

    public boolean adicionarItem(Pedido pedido, int opcaoLanche){
        Lanche lanche = criarLanche(opcaoLanche);
        if (lanche == null){
            return  false;
        }
        pedido.adicionarItem(lanche);
        return true;
    }

    public Collection<Pedido> getPedidos(){
        return gerenciador.getPedidos();
    }

    public  double calcularTotalDoDia(){
        return gerenciador.calcularTotalDoDia();
    }
}
