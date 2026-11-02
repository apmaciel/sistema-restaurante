# Sistema de Restaurante — Projeto 1

Sistema em Java (console) para um restaurante: cardápio, pedidos,
personalização dos lanches e fechamento do dia.

## Vídeo
[Assista aqui]([COLE-O-LINK-DO-VIDEO](https://youtu.be/LX86YDB0lmc])

## O que foi feito

### Nível 1
- `Lanche` com validação de nome e preço (IllegalArgumentException)
- `Pedido` com lista de itens e cálculo do total
- `GerenciadorPedidos` com HashMap e contador automático de pedidos
- `MenuConsole` (interação com a pessoa), `RestauranteFacade` (coordena) e `Main` (fluxo)

### Nível 2
- Interface `ItemCardapio`
- `LancheFactory` para criar os lanches do cardápio
- Adicionais com Decorator: `ComCheddar` e `ComBaconExtra`
- Testes JUnit: preço negativo recusado e X-Bacon com cheddar custando R$ 26

### Nível 3
- Retirar queijo, alface, tomate e cebola
- Modificar pedido: acrescentar item, remover item e cancelar pedido
- Fechamento com as combinações diferentes (HashSet)
- Tratamento de entrada inválida (try/catch com InputMismatchException)

## Padrões de projeto usados
- **Facade:** `RestauranteFacade` esconde do Main como os pedidos e lanches são criados
- **Factory:** `LancheFactory` concentra nome e preço dos lanches num lugar só
- **Decorator:** os adicionais embrulham o lanche e somam descrição e preço

## Organização dos pacotes
- `app`: conversa com a pessoa e coordena
- `cardapio`: lanches, interface, fábrica e adicionais
- `pedido`: comandas e o gerenciador de pedidos

## Como rodar
Abrir no IntelliJ e executar `org.example.app.Main`.
Para os testes: executar `LancheTest` em `src/test/java`.
