package br.edu.ifpb.padroes.atv3.cardapio;

import br.edu.ifpb.padroes.atv3.cardapio.Menu;

public class Item implements Menu {
    private String nome;
    private double preco;
    private String descricao;

    public Item(String nome, double preco, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
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
        return preco;
    }

    @Override
    public void exibir(String identacao) {
        System.out.println(identacao + ":" +getNomeItem() + " : " + getDescricaoItem() + " R$:" + getPrecoItem());
    }
}
