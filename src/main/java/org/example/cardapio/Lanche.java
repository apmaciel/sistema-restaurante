package org.example.cardapio;

public class Lanche implements ItemCardapio{

    private String nome;
    private double preco;

    @Override
    public String getDescricao() {
        return nome;
    }



    public Lanche(String nome, double preco){
        setNome(nome);
        setPreco(preco);

    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("O nome não pode ser nulo e nem vazio!");
        }
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if(preco < 0){
           throw new IllegalArgumentException("O preço não pode ser menor que zero!");
        }
        this.preco = preco;
    }


}
