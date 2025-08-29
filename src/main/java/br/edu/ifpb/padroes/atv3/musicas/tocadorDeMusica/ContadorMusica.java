package br.edu.ifpb.padroes.atv3.musicas.tocadorDeMusica;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;

public class ContadorMusica extends TocadorDecorate{
    private int contador =0;

    public ContadorMusica(Tocador t){
        super(t);
    }

    @Override
    public void tocar(Musica musica){
        super.tocar(musica);
        contador++;
        System.out.println("Quantidade de músicas reproduzidas"+ contador);
    }
}
