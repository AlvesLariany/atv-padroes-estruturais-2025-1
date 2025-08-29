//Adapter: possibilita a transformação de outra estrutura em Menu "nativa" da aplicação

package br.edu.ifpb.padroes.atv3.cardapio.adapter;

import br.edu.ifpb.padroes.atv3.cardapio.Menu;


public class ItemAdapter implements Menu {
    private String nome;
    private String descricao;
    private double preco;

    public ItemAdapter(String nome, double preco, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
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
        System.out.println(identacao+ "- " + nome + " (" + descricao + ") R$:" + preco);
    }
}
