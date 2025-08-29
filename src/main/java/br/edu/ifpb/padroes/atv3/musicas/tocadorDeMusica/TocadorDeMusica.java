package br.edu.ifpb.padroes.atv3.musicas.tocadorDeMusica;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;
import br.edu.ifpb.padroes.atv3.musicas.servico.MusicaNaoEncontradaException;

public class TocadorDeMusica implements  Tocador{

    @Override
    public void tocar (Musica musica){
        if(musica == null){
            throw  new MusicaNaoEncontradaException();
        }
        System.out.println("Tocando musica " + musica.titulo() +"de "+ musica.artista());
        }
    }

