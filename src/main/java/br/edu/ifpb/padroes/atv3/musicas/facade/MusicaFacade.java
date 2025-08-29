package br.edu.ifpb.padroes.atv3.musicas.facade;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;
import br.edu.ifpb.padroes.atv3.musicas.servico.ServicoMusica;
import br.edu.ifpb.padroes.atv3.musicas.tocadorDeMusica.Tocador;

import java.util.List;

public class MusicaFacade {
    private final ServicoMusica servicoMusica;
    private  final Tocador tocador;

    public  MusicaFacade( ServicoMusica servicoMusica, Tocador tocador){
        this.servicoMusica= servicoMusica;
        this.tocador= tocador;
    }

    public List<Musica> listarMusicas(){
        return  servicoMusica.listarMusicas();
    }

    public List<Musica> buscarPorTitulo(String titulo){
        return  servicoMusica.buscarPorTitulo(titulo);
    }
    public List<Musica> buscarPorArtista(String artista){
        return  servicoMusica.buscarPorArtista(artista);
    }
}
