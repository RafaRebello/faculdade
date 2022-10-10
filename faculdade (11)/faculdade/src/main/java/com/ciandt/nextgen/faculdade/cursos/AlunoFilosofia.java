package com.ciandt.nextgen.faculdade.cursos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ciandt.nextgen.faculdade.areas.AlunoDeHumanas;

@Entity
@DiscriminatorValue("Filosofia")
public class AlunoFilosofia extends AlunoDeHumanas {
}
