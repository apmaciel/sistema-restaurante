package org.example.app;

import org.example.cardapio.Lanche;
import org.example.pedido.Pedido;

public class Main {
    static void main() {

        MenuConsole menu = new MenuConsole();
        RestauranteFacade sistema = new RestauranteFacade();
        boolean rodando = true;

        while (rodando) {
            menu.exibirMenu();
            int op = menu.lerOpcao();

            switch (op) {
                case 1:
                    String nome = menu.lerNomeCliente();
                    Pedido pedido = sistema.criarPedido(nome);

                    boolean querMais = true;
                    while (querMais) {
                        int escolha = menu.lerOpcaoLanche();
                        Lanche lanche = sistema.criarLanche(escolha);

                        if (lanche == null) {
                            menu.exibirOpcaoInvalida();
                        } else {
                            if (menu.perguntarRetirar("queijo")) lanche.setQueijo(false);
                            if (menu.perguntarRetirar("alface")) lanche.setAlface(false);
                            if (menu.perguntarRetirar("tomate")) lanche.setTomate(false);
                            if (menu.perguntarRetirar("cebola")) lanche.setCebola(false);

                            boolean cheddar = menu.perguntarCheddar();
                            boolean bacon = menu.perguntarBaconExtra();
                            sistema.adicionarItem(pedido, lanche, cheddar, bacon);
                        }
                        querMais = menu.perguntarMaisItem();
                    }
                    menu.exibirPedido(pedido);
                    break;

                case 2:
                    menu.exibirListaPedidos(sistema.getPedidos());
                    break;

                case 3:
                    double total = sistema.calcularTotalDoDia();
                    menu.exibirFechamentoDoDia(total);
                    break;

                case 0:
                    rodando = false;
                    break;

                default:
                    menu.exibirOpcaoInvalida();
            }
        }

    }
}

