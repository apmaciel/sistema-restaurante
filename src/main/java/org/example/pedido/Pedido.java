package org.example.pedido;

import org.example.cardapio.Lanche;

import java.util.ArrayList;


public class Pedido {
    private int numero;
    private String nomeCliente;
    private ArrayList<Lanche> itens = new ArrayList<>();

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

    public  void adicionarItem(Lanche lanche){
        itens.add(lanche);
    }

    public ArrayList<Lanche> getItens(){
        return itens;
    }

    public double calcularTotal(){
        double total = 0;
        for (Lanche l : itens){
            total += l.getPreco();
        }
       return total;
    }


}
