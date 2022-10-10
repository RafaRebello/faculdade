package com.ciandt.nextgen.faculdade.areas;

import com.ciandt.nextgen.faculdade.modelos.Aluno;
import com.ciandt.nextgen.faculdade.modelos.Disciplina;
import com.ciandt.nextgen.faculdade.modelos.Nota;

public abstract class AlunoDeBiologicas extends Aluno {

    public AlunoDeBiologicas() {
        super.notas.clear();
        super.notas.add(new Nota(this, Disciplina.DISCIPLINA1));
        super.notas.add(new Nota(this, Disciplina.CALCULO1));
        super.notas.add(new Nota(this, Disciplina.BIO_ENG));
        super.notas.add(new Nota(this, Disciplina.SOCIOLOGIA));
    }
}