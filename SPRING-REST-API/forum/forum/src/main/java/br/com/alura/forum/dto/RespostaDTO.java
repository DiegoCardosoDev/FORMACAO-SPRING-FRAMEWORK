package br.com.alura.forum.dto;

import br.com.alura.forum.modelo.Resposta;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RespostaDTO {

    private Long id;
    private String mensagem;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private String nomeAutor;

    public RespostaDTO(Resposta  resposta) {
        this.id = resposta.getId();
        this.mensagem = resposta.getMensagem();
        this.dataCriacao = resposta.getDataCriacao();
        this.nomeAutor = resposta.getAutor().getNome();
    }
}
