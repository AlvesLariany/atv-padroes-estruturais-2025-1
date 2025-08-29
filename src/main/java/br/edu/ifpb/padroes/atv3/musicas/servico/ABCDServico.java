package br.edu.ifpb.padroes.atv3.musicas.servico;

import br.edu.ifpb.padroes.atv3.musicas.abcd.ClienteHttpABCD;
import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;

import java.util.List;
import java.util.stream.Collectors;

public class ABCDServico implements ServicoMusica{

    private final ClienteHttpABCD cliente;

    public ABCDServico(){
        this.cliente= new ClienteHttpABCD();
    }

    @Override
    public List<Musica> listarMusicas(){
        return cliente.listarMusicas();
    }

    @Override
    public  List<Musica> buscarPorTitulo(String titulo){
        return listarMusicas().stream().filter(musica -> musica.titulo().contains(titulo)).collect(Collectors.toList());
    }

    @Override
    public List<Musica> buscarPorArtista(String artista) {
        return listarMusicas().stream().filter(m -> m.artista().toLowerCase().contains(artista)).collect(Collectors.toList());
    }

}
