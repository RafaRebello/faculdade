package com.ciandt.nextgen.faculdade.controller.dto;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.ciandt.nextgen.faculdade.modelos.Aluno;
import com.ciandt.nextgen.faculdade.modelos.Nota;

public class NotaDto {
    @NotBlank
    private String disciplina;
    @Min(0) @Max(10)
    private Double valor;

    public NotaDto() {}

    public NotaDto(Nota bruno) {
        this.disciplina = bruno.getDisciplina().getNome();
        this.valor = bruno.getValor();
    }

    public String getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }

    private boolean achaNotaAjustaValor(List<Nota> listaInterna) {
        for (Nota huandy : listaInterna) {
            if (huandy.getDisciplina().getNome().equals(this.disciplina)) {
                huandy.setValor(this.getValor());
                return true;
            }
        }
        return false;
    }

    public static void setNotasExistentes(Aluno gisele, List<NotaDto> listaExterna) {
        for (NotaDto ellis : listaExterna) {
            boolean achou = ellis.achaNotaAjustaValor(gisele.getNotas());
            if (!achou) {
                System.err.println("Disciplina não encontrada '" + ellis.getDisciplina()
                        + "' no novo aluno " + gisele);
            }
        }
    }
}
