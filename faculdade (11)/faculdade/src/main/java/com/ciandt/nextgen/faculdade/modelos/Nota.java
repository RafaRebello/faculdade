package com.ciandt.nextgen.faculdade.modelos;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity @IdClass(NotaId.class)
public class Nota {

    @Id @ManyToOne @JoinColumn(name="aluno")
    private Aluno aluno;

    @Id @Enumerated(EnumType.STRING) private Disciplina disciplina;

    private Double valor;

    public Nota() {}

    public Nota(Aluno aluno, Disciplina disciplina) {
        this.aluno = aluno;
        this.disciplina = disciplina;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
        this.aluno.autoUpdate();
    }

    @Override
    public String toString() {
        return "{" + disciplina + "=" + valor + "}";
    }
}
