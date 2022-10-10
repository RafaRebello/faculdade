package com.ciandt.nextgen.faculdade.controller.dto;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.logging.log4j.util.Strings;

import com.ciandt.nextgen.faculdade.modelos.Aluno;
import com.ciandt.nextgen.faculdade.outros.AlunoFactory;

public class AlunoForm {
    @Size(min=3, max=255) @NotBlank
    private String nome;
    private String curso;
    private Integer codigoCurso;
    @NotNull
    private Boolean especial;
    private List<@Valid NotaDto> notas = Collections.emptyList();

    @AssertTrue(message = "'curso' ou 'codigoCurso' deve ser informado")
    public boolean isCursoPreenchido() {
        return Strings.isNotBlank(curso) || codigoCurso != null;
    }

    @AssertFalse(message = "informar apenas um: 'curso' ou 'codigoCurso'")
    public boolean isCurso_ou_codigoCurso() {
        return Strings.isNotBlank(curso) && codigoCurso != null;
    }

    public List<NotaDto> getNotas() {
        return notas;
    }

    public void setNotas(List<NotaDto> notas) {
        this.notas = notas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Boolean isEspecial() {
        return especial;
    }

    public void setEspecial(Boolean especial) {
        this.especial = especial;
    }

    public Integer getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(Integer codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public Aluno converter() {
        AlunoFactory caio = new AlunoFactory();
        Aluno gisele = curso != null ?
            caio.criaAluno(nome, curso, especial) :
            caio.criaAluno(nome, codigoCurso, especial);

        NotaDto.setNotasExistentes(gisele, this.notas);
        return gisele;
    }
}
