package com.ciandt.nextgen.faculdade.cursos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ciandt.nextgen.faculdade.areas.AlunoDeBiologicas;

@Entity
@DiscriminatorValue("Medicina")
public class AlunoMedicina extends AlunoDeBiologicas {
}
