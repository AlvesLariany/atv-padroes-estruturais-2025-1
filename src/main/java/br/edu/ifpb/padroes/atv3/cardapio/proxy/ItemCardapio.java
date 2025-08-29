//Proxy: usado para controlar o acesso ao preço, na implemetaçao atual não é tão crucial
//mas pensando em evolução pode ser interessante a sua existeência

package br.edu.ifpb.padroes.atv3.cardapio.proxy;

import br.edu.ifpb.padroes.atv3.cardapio.Menu;

public class ItemCardapio implements Menu {
    private Menu item;
    private boolean autorizado;

    public ItemCardapio(Menu item, boolean autorizado) {
        this.item = item;
        this.autorizado = autorizado;
    }

    @Override
    public String getNomeItem() {
        return item.getNomeItem();
    }

    @Override
    public String getDescricaoItem() {
        return item.getDescricaoItem();
    }


    @Override
    public double getPrecoItem() {
        if (autorizado) {
            return item.getPrecoItem();
        } else {
            throw new SecurityException("Acesso ao preço não autorizado!");
        }
    }

    @Override
    public void exibir(String identacao) {
        if (autorizado) {
            item.exibir(identacao);
        } else {
            System.out.println(identacao + "- " + getNomeItem() + " (Preço restrito)");
        }
    }
}
