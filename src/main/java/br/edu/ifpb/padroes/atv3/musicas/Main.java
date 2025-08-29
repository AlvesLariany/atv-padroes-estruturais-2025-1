package br.edu.ifpb.padroes.atv3.musicas;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;
import br.edu.ifpb.padroes.atv3.musicas.facade.MusicaFacade;
import br.edu.ifpb.padroes.atv3.musicas.servico.AdapterMusica;
import br.edu.ifpb.padroes.atv3.musicas.servico.ServicoMusica;
import br.edu.ifpb.padroes.atv3.musicas.servico.ServicoMusicaProxy;
import br.edu.ifpb.padroes.atv3.musicas.tocadorDeMusica.ContadorMusica;
import br.edu.ifpb.padroes.atv3.musicas.tocadorDeMusica.Tocador;
import br.edu.ifpb.padroes.atv3.musicas.tocadorDeMusica.TocadorDeMusica;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        ServicoMusica adapterXPTO = new AdapterMusica();
        ServicoMusica proxy = new ServicoMusicaProxy(adapterXPTO, 60);
        Tocador tocador = new ContadorMusica(new TocadorDeMusica());
        MusicaFacade facade = new MusicaFacade(proxy, tocador);



        System.out.println("Todas as músicas");
        List<Musica> todas = facade.listarMusicas();
        todas.forEach(m -> System.out.println(m.id() + " - " + m.titulo() + " - " + m.artista()));

        System.out.println("\n Buscar por artista:");
        List<Musica> porArtista = facade.buscarPorArtista("Queen");
        porArtista.forEach(m -> System.out.println(m.titulo() + " - " + m.artista()));

        System.out.println("\n Buscar por título:" + porArtista);
        List<Musica> porTitulo = facade.buscarPorTitulo("Love");
        porTitulo.forEach(m -> System.out.println(m.titulo() + " - " + m.artista()));

        System.out.println("\nTocando músicas pelo Facade ");
        // Tocar a primeira música
        if (!todas.isEmpty()) {
            tocador.tocar(todas.get(0));
        }
        // Tocar a segunda música
        if (todas.size() > 1) {
            tocador.tocar(todas.get(4));
        }
    }
}
