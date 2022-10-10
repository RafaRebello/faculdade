package com.ciandt.nextgen.faculdade.areas;

import com.ciandt.nextgen.faculdade.modelos.Aluno;
import com.ciandt.nextgen.faculdade.modelos.Disciplina;
import com.ciandt.nextgen.faculdade.modelos.Nota;

public abstract class AlunoDeHumanas extends Aluno {

    public AlunoDeHumanas() {
        super.notas.add(new Nota(this, Disciplina.DISCIPLINA3));
        super.notas.add(new Nota(this, Disciplina.DISCIPLINA4));
        super.notas.add(new Nota(this, Disciplina.SOCIOLOGIA));
    }
}