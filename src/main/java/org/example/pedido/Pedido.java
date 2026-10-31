package org.example.pedido;

import org.example.cardapio.ItemCardapio;

import java.util.ArrayList;


public class Pedido {
    private int numero;
    private String nomeCliente;
    private ArrayList<ItemCardapio> itens = new ArrayList<>();

    public Pedido(int numero, String nomeCliente) {
        this.numero = numero;
        setNomeCliente(nomeCliente);
    }

    public int getNumero(){
        return numero;
    }
    public String getNomeCliente(){
        return  nomeCliente;

    }

    public void setNomeCliente(String nomeCliente) {
        if (nomeCliente == null || nomeCliente.trim().isEmpty()){
            throw  new IllegalArgumentException("o nome do cliente não pode ser vazio!");
        }
        this.nomeCliente = nomeCliente;
    }

    public  void adicionarItem( ItemCardapio item){
        itens.add(item);
    }

    public ArrayList<ItemCardapio> getItens(){
        return itens;
    }

    public double calcularTotal(){
        double total = 0;
        for ( ItemCardapio item : itens){
            total += item.getPreco();
        }
       return total;
    }

    public boolean removerItem(int indice) {
        if (indice < 0 || indice >= itens.size()) {
            return false;              // posição que não existe
        }
        itens.remove(indice);
        return true;
    }


}
