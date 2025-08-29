package br.edu.ifpb.padroes.atv3.cardapio;

import br.edu.ifpb.padroes.atv3.cardapio.adapter.ItemAdapter;
import br.edu.ifpb.padroes.atv3.cardapio.composite.Combo;
import br.edu.ifpb.padroes.atv3.cardapio.decorator.Desconto;
import br.edu.ifpb.padroes.atv3.cardapio.proxy.ItemCardapio;

public class Main {
    public static void main(String[] args) {
        Cardapio cardapio = new Cardapio();

        // Itens simples
        Menu pizza = new Item("Pastel de frango", 7.00, "Pastel com muito frango");
        Menu refrigerante = new Item("Coca zero", 8.0, "Bebida gelada");
        Menu sobremesa = new Item("Morango do amor", 12.0, "Sobremesa deliciosa");

        // Combo (Composite)
        Combo combo1 = new Combo("Combo Família", "Pizza + Refrigerante");
        combo1.addItem(pizza);
        combo1.addItem(refrigerante);

        // Adapter para recebr de outros lugares
        Menu sushiAdaptado = new ItemAdapter("Morango do amor gourmet", 500.0, "Morango do amor decorado");

        // Proxy
        Menu pudimRestrito = new ItemCardapio(sobremesa, false);

        // Decorator (aplicando desconto)
        Menu pizzaComDesconto = new Desconto(pizza, 1.50);

        // Adiciona tudo no cardápio
        cardapio.addItem(combo1);
        cardapio.addItem(sushiAdaptado);
        cardapio.addItem(pudimRestrito);
        cardapio.addItem(pizzaComDesconto);

        // Exibe cardápio e preço total
        cardapio.exibirCardapio();
        System.out.println("Preço total: R$ " + cardapio.calcularPrecoTotal());
    }
}
