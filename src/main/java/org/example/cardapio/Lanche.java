package org.example.cardapio;

public class Lanche implements ItemCardapio{

    private String nome;
    private double preco;
    private boolean queijo = true;
    private boolean alface = true;
    private boolean tomate = true;
    private boolean cebola = true;

    public boolean isCebola() {
        return cebola;
    }

    public void setCebola(boolean cebola) {
        this.cebola = cebola;
    }

    public boolean isTomate() {
        return tomate;
    }

    public void setTomate(boolean tomate) {
        this.tomate = tomate;
    }

    public boolean isAlface() {
        return alface;
    }

    public void setAlface(boolean alface) {
        this.alface = alface;
    }

    public boolean isQueijo() {
        return queijo;
    }

    public void setQueijo(boolean queijo) {
        this.queijo = queijo;
    }

    @Override
    public String getDescricao() {
        String desc = nome;
        if (!queijo) desc += " ,sem queijo";
        if (!alface) desc += " ,sem alface";
        if (!tomate) desc += " ,sem tomate";
        if (!cebola) desc += " ,sem cebola";

        return desc;
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
