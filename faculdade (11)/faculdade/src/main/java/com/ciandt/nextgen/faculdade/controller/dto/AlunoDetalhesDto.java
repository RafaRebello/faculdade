package com.ciandt.nextgen.faculdade.controller.dto;

import java.util.LinkedList;
import java.util.List;

import com.ciandt.nextgen.faculdade.modelos.Aluno;
import com.ciandt.nextgen.faculdade.modelos.Nota;

public class AlunoDetalhesDto extends AlunoDto {
    private boolean especial;
    private List<NotaDto> notas;

    public AlunoDetalhesDto(Aluno aluno) {
        super(aluno);
        this.especial = aluno.getEspecial();
        // notas = aluno.getNotas().stream().map(NotaDto::new).toList();
        notas = new LinkedList<>();
        for (Nota leo : aluno.getNotas()) {
            notas.add(new NotaDto(leo));
        }
    }

    public List<NotaDto> getNotas() {
        return notas;
    }

    public boolean isEspecial() {
        return especial;
    }
}
