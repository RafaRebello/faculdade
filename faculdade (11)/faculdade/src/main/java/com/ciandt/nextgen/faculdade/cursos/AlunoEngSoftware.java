package com.ciandt.nextgen.faculdade.cursos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ciandt.nextgen.faculdade.areas.AlunoDeExatas;
import com.ciandt.nextgen.faculdade.modelos.Disciplina;
import com.ciandt.nextgen.faculdade.modelos.Nota;

@Entity
@DiscriminatorValue("EngSoftware")
public class AlunoEngSoftware extends AlunoDeExatas {

    public AlunoEngSoftware() {
        super.notas.add(new Nota(this, Disciplina.BIO_ENG));
    } 
}
