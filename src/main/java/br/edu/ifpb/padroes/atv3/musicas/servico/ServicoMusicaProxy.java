package br.edu.ifpb.padroes.atv3.musicas.servico;


import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

//com o proxy sera crisado um cache para que não haja sobrecarga toda vez que o backend for solicitado
public class ServicoMusicaProxy implements  ServicoMusica{

    private final ServicoMusica referenciaMusica;
    private List<Musica > cache;
    private Instant cacheDeTempo;
    private final long tempoCache;

    public ServicoMusicaProxy( ServicoMusica referenciaMusica, long tempoCache)
    {
        this.referenciaMusica= referenciaMusica;
        this.tempoCache = tempoCache;
    }
    //
    private boolean cacheEhValido(){
        if(cache == null || cacheDeTempo== null){
            return false;
        }

        return  Instant.now().isBefore(cacheDeTempo.plusSeconds(tempoCache));
    }

    private  void atualizaCache() {
        if (!cacheEhValido()) {
            cache = referenciaMusica.listarMusicas();
            cacheDeTempo = Instant.now();
        }
    }
        @Override
         public  List<Musica> listarMusicas(){
            atualizaCache();
            return cache;
        }

       @Override
        public List<Musica> buscarPorArtista(String artista){
        atualizaCache();
        return  cache.stream().filter(musica -> musica.artista().contains(artista)).collect(Collectors.toList());
       }

       @Override
        public List<Musica> buscarPorTitulo(String titulo){
        atualizaCache();
        return cache.stream().filter(musica -> musica.titulo().contains(titulo)).collect(Collectors.toList());
       }
    }

