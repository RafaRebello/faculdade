package com.ciandt.nextgen.faculdade.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.ciandt.nextgen.faculdade.modelos.Aluno;

public class AlunoDto {
    private final Long matricula;
    private final String nome;
    private final String curso;
    private final Double mediaNotas;

    public AlunoDto(Aluno aluno) {
        this.matricula = aluno.getMatricula();
        this.nome = aluno.getNome();
        this.curso = aluno.getClass().getSimpleName().substring(5);
        this.mediaNotas = aluno.getMedia();
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public Double getMediaNotas() {
        return mediaNotas;
    }

    public Long getMatricula() {
        return matricula;
    }

    public static List<AlunoDto> converter(List<Aluno> alunos) {
        // return alunos.stream().map(AlunoDto::new).toList();
        List<AlunoDto> dto = new ArrayList<>(alunos.size());
        for (Aluno aluno : alunos) {
            dto.add(new AlunoDto(aluno));
        }
        return dto;
    }
}
