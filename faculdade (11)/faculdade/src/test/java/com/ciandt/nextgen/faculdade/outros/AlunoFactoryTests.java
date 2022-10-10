package com.ciandt.nextgen.faculdade.outros;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.ciandt.nextgen.faculdade.cursos.AlunoEngSoftware;

import static com.ciandt.nextgen.faculdade.outros.AlunoFactory.*;
import static org.junit.jupiter.api.Assertions.*;

public class AlunoFactoryTests {
    AlunoFactory fabrica = new AlunoFactory();

    @ParameterizedTest
    @ValueSource(strings = {MEDICINA, ENG_SOFTWARE, ESTATISTICA, PSICOLOGIA, FILOSOFIA})
    void criaAlunoNotNullComNomeNomeCursoValidos(String nomeCurso) {
        assertNotNull(fabrica.criaAluno("goiaba", nomeCurso));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void criaAlunoNotNullComNomeCodigoCursoValidos(int codigoCurso) {
        assertNotNull(fabrica.criaAluno("goiaba", codigoCurso));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dados_alunos_validos.csv")
    void criaAlunoComEspecialCorretoParaVariosCursos(String nome, int codigoCurso, boolean especial) {
        assertEquals(especial, fabrica.criaAluno(nome, codigoCurso, especial).getEspecial());
    }

    @Test
    void criaAlunoCorretoComNomeNomeCursoEspecial() {
        assertInstanceOf(AlunoEngSoftware.class, fabrica.criaAluno("goiaba", ENG_SOFTWARE, true));
    }

    @Test
    void criaAlunoFalhaComCursoInvalido() {
        assertNull(fabrica.criaAluno("goiaba", "river"));
    }

    @Test
    void criaAlunoFalhaComCodigoCursoInvalido() {
        assertNull(fabrica.criaAluno("goiaba", 0));
    }
}
