package br.edu.ifpb.padroes.atv3.musicas.servico;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;

import java.util.List;

public interface ServicoMusica {
    List<Musica> listarMusicas();

    List<Musica> buscarPorTitulo(String titulo);
    List<Musica> buscarPorArtista(String artista);

}
