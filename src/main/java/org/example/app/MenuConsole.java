package org.example.app;

import org.example.cardapio.ItemCardapio;
import org.example.pedido.Pedido;

import java.util.Collection;
import java.util.Scanner;

public class MenuConsole {

    private Scanner sc = new Scanner(System.in);

    public void exibirMenu(){
        System.out.println("\n=== Restaurante ===");
        System.out.println("1 - Registrar novo pedido");
        System.out.println("2 - Listar pedidos do dia");
        System.out.println("3 - Fechar restaurante");
        System.out.println("4 - Modificar pedido");
        System.out.println("0 - Sair ");
        System.out.print("Escolha:  " );
    }

    public  int lerOpcao(){
        int op = sc.nextInt();
        sc.nextLine();
        return op;
    }

    public String lerNomeCliente(){
        System.out.print("Nome do cliente: ");
        return sc.nextLine();
    }

    public int lerOpcaoLanche(){
        System.out.println("1 - X-Burger R$ 16,00");
        System.out.println("2 - X-Salada R$ 18,00");
        System.out.println("3 - X-Bacon R$ 22,00");
        System.out.print("Qual lanche? ");
        return lerOpcao();

    }

    public boolean perguntarMaisItem(){
        System.out.print("Deseja mais um item (s/n): ");
        String resposta = sc.nextLine();
        return  resposta.equalsIgnoreCase("s");
    }

    public void exibirPedido(Pedido pedido) {
        System.out.println("Pedido nº " + pedido.getNumero() + " - " + pedido.getNomeCliente());
        for (ItemCardapio item : pedido.getItens()) {
            System.out.printf("  %s  R$ %.2f%n", item.getDescricao(), item.getPreco());
        }
        System.out.printf("Total: R$ %.2f%n", pedido.calcularTotal());
    }

    public void exibirListaPedidos(Collection<Pedido> pedidos){
        if (pedidos.isEmpty()){
            System.out.println("Nenhum pedido hoje.");
            return;
        }
        for (Pedido p : pedidos){
            exibirPedido(p);
        }
    }

    public void exibirFechamentoDoDia(double total){
        System.out.printf("=== Fechamento === %nTotal vendido: R$ %.2f ", total);
    }

    public void exibirOpcaoInvalida(){
        System.out.println("Opção inválida, tente de novo.");
    }

    public boolean perguntarCheddar(){
        System.out.print("Adicionar cheddar ( + R$ 4,00) ? (s/n): ");
        String resposta = sc.nextLine();
        return resposta.equalsIgnoreCase("s");
    }

    public boolean perguntarBaconExtra(){
        System.out.print("Adicionar bacon extra ( + R$ 6,00) ? (s/n): ");
        String resposta = sc.nextLine();
        return resposta.equalsIgnoreCase("s");


    }
    public boolean perguntarRetirar(String ingrediente){
        System.out.print("Retirar " + ingrediente + "? (s/n): ");
        String resposta = sc.nextLine();
        return resposta.equalsIgnoreCase("s");
    }

    public int lerNumeroPedido() {
        System.out.print("Número do pedido: ");
        return lerOpcao();
    }

    public int lerAcaoModificar() {
        System.out.println("1 - Acrescentar item");
        System.out.println("2 - Remover item");
        System.out.println("3 - Cancelar pedido");
        System.out.print("Escolha: ");
        return lerOpcao();
    }

    public void exibirItensNumerados(Pedido pedido) {
        for (int i = 0; i < pedido.getItens().size(); i++) {
            ItemCardapio item = pedido.getItens().get(i);
            System.out.printf("%d - %s  R$ %.2f%n", i + 1, item.getDescricao(), item.getPreco());
        }
    }

    public int lerNumeroItem() {
        System.out.print("Qual item remover? ");
        return lerOpcao();
    }

    public void exibirPedidoNaoEncontrado() {
        System.out.println("Pedido não encontrado.");
    }

    public void exibirPedidoCancelado() {
        System.out.println("Pedido cancelado.");
    }
}
