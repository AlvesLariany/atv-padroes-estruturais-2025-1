package br.edu.ifpb.padroes.atv3.cardapio;

import br.edu.ifpb.padroes.atv3.cardapio.Menu;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {
    //armazena os itens, incluidno os combos
    private List<Menu> itens = new ArrayList<>();

    public void addItem(Menu item) {
        itens.add(item);
    }

    public void exibirCardapio() {
        System.out.println("Cardápio");
        for (Menu item : itens) {
            item.exibir(" ");
        }
    }

    public double calcularPrecoTotal() {
        double total = 0;
        for (Menu item : itens) {
            try {
                total += item.getPrecoItem();
            } catch (SecurityException e) {

            }
        }
        return total;
    }
}
