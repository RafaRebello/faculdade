package com.ciandt.nextgen.faculdade.modelos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Iterator;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.ciandt.nextgen.faculdade.cursos.AlunoMedicina;

public class AlunoTests {

    @Nested
    class CalculaMedia {
        @Test
        void retornaNullSeNaoTiverNotasPreenchidas() {
            assertNull(criaAlunoComNotas().getMedia());
        }

        @Test
        void ignoraNotasNaoPreenchidas() {
            assertEquals(7., criaAlunoComNotas(6., null, 8.).getMedia());
        }

        @Test
        void mediaDeTodasAsNotas() {
            assertEquals(5., criaAlunoComNotas(3. ,4., 6., 7.).getMedia());
        }
    }

    @Test
    void setEspecialAtualizaSituacaoQdoMuda() {
        Aluno mutante = criaAlunoComNotas(6.);
        assertEquals(Situacao.EM_RECUPERACAO, mutante.getSituacao());
        mutante.setEspecial(true);
        assertEquals(Situacao.EM_ANALISE_PELO_CORPO_DOCENTE, mutante.getSituacao());
        mutante.setEspecial(false);
        assertEquals(Situacao.EM_RECUPERACAO, mutante.getSituacao());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/tabela_de_resultados_do_pegaSituacao.csv", numLinesToSkip = 1)
    void getSituacaoTesteCenarios(Double nota, boolean especial, Situacao resultado) {
        assertEquals(resultado, criaAlunoComNotas(especial, nota).getSituacao());
    }

    private static Aluno criaAlunoComNotas(boolean especial, Double... valoresNotas) {
        Aluno cobaia = criaAlunoComNotas(valoresNotas);
        cobaia.setEspecial(especial);
        return cobaia;
    }

    private static Aluno criaAlunoComNotas(Double... valoresNotas) {
        Aluno cobaia = new AlunoMedicina();
        Iterator<Nota> iterator = cobaia.getNotas().iterator();
        for (int i = 0; i < valoresNotas.length && iterator.hasNext(); i++) {
            iterator.next().setValor(valoresNotas[i]);
        }
        return cobaia;
    }
}
