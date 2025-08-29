//Decorator: adiciona a possibilidade de aplicar desconto sem a necessidadede de mudar a classe Item

package br.edu.ifpb.padroes.atv3.cardapio.decorator;

import br.edu.ifpb.padroes.atv3.cardapio.Menu;

public class Desconto implements Menu {
    private Menu item;
    private double desconto;

    public Desconto(Menu item, double desconto) {
        this.item = item;
        this.desconto = desconto;
    }

    @Override
    public String getNomeItem() {
        return item.getNomeItem();
    }

    @Override
    public String getDescricaoItem() {
        return item.getDescricaoItem() + " (com desconto)";
    }

    @Override
    public double getPrecoItem() {
        return item.getPrecoItem() - desconto;
    }

    @Override
    public void exibir(String identacao) {
        System.out.println(identacao + "- " + getNomeItem() + " (" + getDescricaoItem() + ") R$" + getPrecoItem());
    }
}
