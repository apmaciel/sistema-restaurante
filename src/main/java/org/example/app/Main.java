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

                    Pedido pedido;
                    try {
                        pedido = sistema.criarPedido(nome);
                    } catch (IllegalArgumentException e) {
                        menu.exibirErro(e.getMessage());
                        break;
                    }

                    boolean querMais = true;
                    while (querMais) {
                        adicionarItemAoPedido(menu, sistema, pedido);
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
                    menu.exibirCombinacoes(sistema.getCombinacoes());
                    break;

                case 4:
                    int num = menu.lerNumeroPedido();
                    Pedido p = sistema.buscarPedido(num);

                    if (p == null) {
                        menu.exibirPedidoNaoEncontrado();
                        break;
                    }

                    menu.exibirPedido(p);
                    int acao = menu.lerAcaoModificar();

                    if (acao == 1) {
                        adicionarItemAoPedido(menu, sistema, p);        // ← usa o mesmo cartão
                        menu.exibirPedido(p);
                    } else if (acao == 2) {
                        menu.exibirItensNumerados(p);
                        int item = menu.lerNumeroItem();
                        if (sistema.removerItem(p, item)) {
                            menu.exibirPedido(p);
                        } else {
                            menu.exibirOpcaoInvalida();
                        }
                    } else if (acao == 3) {
                        sistema.cancelarPedido(num);
                        menu.exibirPedidoCancelado();
                    } else {
                        menu.exibirOpcaoInvalida();
                    }
                    break;


                case 0:
                    rodando = false;
                    break;

                default:
                    menu.exibirOpcaoInvalida();
            }
        }

    }

    private static void adicionarItemAoPedido(MenuConsole menu, RestauranteFacade sistema, Pedido pedido) {
        int escolha = menu.lerOpcaoLanche();
        Lanche lanche = sistema.criarLanche(escolha);

        if (lanche == null) {
            menu.exibirOpcaoInvalida();
            return;
        }
        if (menu.perguntarRetirar("queijo")) lanche.setQueijo(false);
        if (menu.perguntarRetirar("alface")) lanche.setAlface(false);
        if (menu.perguntarRetirar("tomate")) lanche.setTomate(false);
        if (menu.perguntarRetirar("cebola")) lanche.setCebola(false);

        boolean cheddar = menu.perguntarCheddar();
        boolean bacon = menu.perguntarBaconExtra();
        sistema.adicionarItem(pedido, lanche, cheddar, bacon);

    }

}