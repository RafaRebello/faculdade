package com.ciandt.nextgen.faculdade.cursos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ciandt.nextgen.faculdade.areas.AlunoDeExatas;

@Entity
@DiscriminatorValue("Estatistica")
public class AlunoEstatistica extends AlunoDeExatas {
}
