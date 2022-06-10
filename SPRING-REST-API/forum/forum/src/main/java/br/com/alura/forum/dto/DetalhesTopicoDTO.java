package br.com.alura.forum.dto;


import br.com.alura.forum.modelo.StatusTopico;
import br.com.alura.forum.modelo.Topico;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class DetalhesTopicoDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private String nomeAutor;
    private StatusTopico statusTopico;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    List<RespostaDTO> respostas;

    public DetalhesTopicoDTO(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
        this.nomeAutor = topico.getAutor().getNome();
        this.statusTopico = topico.getStatus();
        this.respostas = new ArrayList<>();
        this.respostas.addAll(topico.getRespostas()
                .stream().map(RespostaDTO::new).collect(Collectors.toList()));
    }


}
