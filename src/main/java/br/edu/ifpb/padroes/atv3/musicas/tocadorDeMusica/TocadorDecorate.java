package br.edu.ifpb.padroes.atv3.musicas.tocadorDeMusica;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;

public abstract class TocadorDecorate implements Tocador {
    protected  final Tocador t;

    public  TocadorDecorate(Tocador t){
        this.t=t;
    }


    @Override
    public void tocar(Musica musica){
        t.tocar(musica);
    }
}
