package br.com.alura.forum.form;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TopicoForm {

    private String titulo;
    private String mensagem;
    private String nomeCurso;





    public Topico converter(CursoRepository cursoRepository) {
        Curso curso = cursoRepository.findByname(nomeCurso);
        return new Topico(titulo, mensagem, curso);
    }
}
