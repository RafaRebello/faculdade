package com.ciandt.nextgen.faculdade.cursos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.ciandt.nextgen.faculdade.modelos.Nota;

public class AlunoPsicologiaTests {
    List<Nota> cobaia = new AlunoPsicologia().getNotas();

    @Test
    void deveTer5Notas() {
        assertEquals(5, cobaia.size());
    }

    @ParameterizedTest
    @ValueSource(strings = {"DISCIPLINA1", "DISCIPLINA2", "DISCIPLINA3", "DISCIPLINA4", "SOCIOLOGIA"})
    void deveTerDisciplina(String disciplina) {
        assertTrue(cobaia.stream().anyMatch(n -> disciplina.equals(n.getDisciplina().name())));
    }
}
