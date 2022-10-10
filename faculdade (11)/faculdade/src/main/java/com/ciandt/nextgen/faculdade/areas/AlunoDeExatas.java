package com.ciandt.nextgen.faculdade.areas;

import com.ciandt.nextgen.faculdade.modelos.Aluno;
import com.ciandt.nextgen.faculdade.modelos.Disciplina;
import com.ciandt.nextgen.faculdade.modelos.Nota;

public abstract class AlunoDeExatas extends Aluno {
    
    public AlunoDeExatas() {
        super.notas.add(new Nota(this, Disciplina.CALCULO1));
        super.notas.add(new Nota(this, Disciplina.CALCULO2));
        super.notas.add(new Nota(this, Disciplina.CALCULO3));
        super.notas.add(new Nota(this, Disciplina.FISICA));
    }
}