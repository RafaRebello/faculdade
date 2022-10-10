package com.ciandt.nextgen.faculdade.cursos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.ciandt.nextgen.faculdade.modelos.Nota;

public class AlunoEstatisticaTests {
    List<Nota> cobaia = new AlunoEstatistica().getNotas();

    @Test
    void deveTer6Notas() {
        assertEquals(6, cobaia.size());
    }

    @ParameterizedTest
    @ValueSource(strings = {"CALCULO1", "CALCULO2", "CALCULO3", "DISCIPLINA1", "DISCIPLINA2", "FISICA"})
    void deveTerDisciplina(String disciplina) {
        assertTrue(cobaia.stream().anyMatch(n -> disciplina.equals(n.getDisciplina().name())));
    }
}
