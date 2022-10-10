package com.ciandt.nextgen.faculdade.controller.dto;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import com.ciandt.nextgen.faculdade.modelos.Aluno;

public class AlunoUpdateForm {
    @Size(min=3, max=255)
    private String nome;
    private Boolean especial;
    private List<@Valid NotaDto> notas = Collections.emptyList();

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Boolean getEspecial() {
        return especial;
    }
    public void setEspecial(Boolean especial) {
        this.especial = especial;
    }
    public List<NotaDto> getNotas() {
        return notas;
    }
    public void setNotas(List<NotaDto> notas) {
        this.notas = notas;
    }

    public void atualizar(Aluno flavio) {
        if (this.nome != null) flavio.setNome(this.nome);
        if (this.especial != null) flavio.setEspecial(this.especial);
        NotaDto.setNotasExistentes(flavio, this.notas);
    }
}
