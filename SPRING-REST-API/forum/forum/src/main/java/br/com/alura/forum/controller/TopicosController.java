package br.com.alura.forum.controller;

import br.com.alura.forum.dto.TopicoDTO;
import br.com.alura.forum.form.TopicoForm;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private CursoRepository cursoRepository;


    public TopicosController(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    @GetMapping
    public List<TopicoDTO> lista() {
            List<Topico> topicos = topicoRepository.findAll();
            return TopicoDTO.converter(topicos);

    }

    @PostMapping
    public ResponseEntity<TopicoDTO> cadastrar(@RequestBody TopicoForm topicoForm, UriComponentsBuilder uriBuilder) {
        Topico topico = topicoForm.converter(cursoRepository);
        topicoRepository.save(topico);
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDTO(topico));

    }


}
