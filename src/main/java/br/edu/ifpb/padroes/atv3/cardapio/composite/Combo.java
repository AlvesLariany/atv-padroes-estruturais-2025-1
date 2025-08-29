//Composite: vai lidar com combos e itens de maneira hierarquica exibindo o combo e os itens juntos

package br.edu.ifpb.padroes.atv3.cardapio.composite;

import br.edu.ifpb.padroes.atv3.cardapio.Menu;

import java.util.ArrayList;
import java.util.List;

public class Combo implements Menu {
    private String nome;
    private String descricao;
    private List<Menu> itens = new ArrayList<>();

    public Combo(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
    }

    public void addItem(Menu item){
        itens.add(item);
    }

    @Override
    public String getNomeItem() {
        return nome;
    }

    @Override
    public String getDescricaoItem() {
        return descricao;
    }

    @Override
    public double getPrecoItem() {
        double total = 0;
        for(Menu item : itens) {
            total += item.getPrecoItem();
        }
        return total;
    }

    @Override
    public void exibir(String identacao) {
        System.out.println(identacao + "+ Combo: " + getNomeItem() + " (" + getDescricaoItem() + ") R$" + getPrecoItem());
        for(Menu item : itens){
            item.exibir( identacao + " ");
        }
    }
}
