package org.example.app;

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
                        if (!sistema.adicionarItem(pedido, escolha)) {
                            menu.exibirOpcaoInvalida();
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
