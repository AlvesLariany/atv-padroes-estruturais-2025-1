package br.edu.ifpb.padroes.atv3.musicas.servico;


import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;
import br.edu.ifpb.padroes.atv3.musicas.xpto.Song;
import br.edu.ifpb.padroes.atv3.musicas.xpto.ClientHttpXPTO;
import java.util.List;
import java.util.stream.Collectors;

//Irá adaptar os o novo formato de Musica ( Song- XPTO) para Musica (Musica-ABCD)
public class AdapterMusica implements  ServicoMusica{
    private final ClientHttpXPTO cliente;

    public AdapterMusica(){
        this.cliente = new ClientHttpXPTO();
    }

    private Musica SongParaMusica(Song song){
        return  new Musica(song.id(), song.title(), song.artist(), song.year(), song.genre());
    }

    @Override
    public List<Musica> listarMusicas(){
        List<Song> songs = cliente.findAll();
        return songs.stream().map(this::SongParaMusica).collect(Collectors.toList());
    }

    @Override
    public List<Musica> buscarPorArtista(String artista) {
        return listarMusicas().stream().filter(m -> m.artista().toLowerCase().contains(artista.toLowerCase())).collect(Collectors.toList());
    }

    @Override
    public  List<Musica> buscarPorTitulo(String titulo){
        return listarMusicas().stream().filter(musica -> musica.titulo().contains(titulo)).collect(Collectors.toList());
    }
}
