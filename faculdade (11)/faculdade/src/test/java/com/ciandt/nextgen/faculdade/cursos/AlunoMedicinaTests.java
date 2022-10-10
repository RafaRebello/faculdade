package com.ciandt.nextgen.faculdade.cursos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.ciandt.nextgen.faculdade.modelos.Nota;

public class AlunoMedicinaTests {
    List<Nota> cobaia = new AlunoMedicina().getNotas();

    @Test
    void deveTer4Notas() {
        assertEquals(4, cobaia.size());
    }

    @ParameterizedTest
    @ValueSource(strings = {"CALCULO1", "DISCIPLINA1", "BIO_ENG", "SOCIOLOGIA"})
    void deveTerDisciplina(String disciplina) {
        assertTrue(cobaia.stream().anyMatch(n -> disciplina.equals(n.getDisciplina().name())));
    }
}
