package br.com.alura.forum.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErroDeFormularioDto {

    private String campo;
    private String erro;
}
