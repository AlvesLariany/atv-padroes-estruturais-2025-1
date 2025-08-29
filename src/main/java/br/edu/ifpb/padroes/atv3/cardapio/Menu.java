package br.edu.ifpb.padroes.atv3.cardapio;

public interface Menu {
    String getNomeItem();
    String getDescricaoItem();
    double getPrecoItem();

    void exibir(String identacao);
}
