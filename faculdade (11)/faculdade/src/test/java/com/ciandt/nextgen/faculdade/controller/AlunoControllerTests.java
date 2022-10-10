package com.ciandt.nextgen.faculdade.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ciandt.nextgen.faculdade.outros.AlunoFactory;

public class AlunoControllerTests {
    AlunoRepositoryMock mock = new AlunoRepositoryMock();
    AlunoController cobaia = new AlunoController(mock);

    @Nested
    class Detalhar {
        @Test
        void retonarAlunoValidoQdoIdExiste() {
            assertNotNull(cobaia.detalhar(1L).getBody());
        }
    
        @Test
        void retonarNullQdoIdNaoExiste() {
            assertNull(cobaia.detalhar(10L).getBody());
        }    
    }

    @Nested
    class Deletar {
        @Test
        void retorna200QdoIdExiste() {
            ResponseEntity<?> retornoDeletar = cobaia.deletar(1L);
            assertEquals(1, mock.contadorDeletar);
            assertEquals(HttpStatus.OK, retornoDeletar.getStatusCode());
        }
        
        @Test
        void retorna404QdoIdNaoExiste() {
            ResponseEntity<?> retornoDeletar = cobaia.deletar(10L);
            assertEquals(0, mock.contadorDeletar);
            assertEquals(HttpStatus.NOT_FOUND, retornoDeletar.getStatusCode());
        }
    
        @Test
        void funcionaSomente1VezQdoIdExisteMasExecutado2Vezes() {
            cobaia.deletar(1L);
            assertEquals(1, mock.contadorDeletar);
            cobaia.deletar(1L);
            assertEquals(1, mock.contadorDeletar); //não teve novas chamadas no deletebyId
        }
    }

    @Nested
    class Listar {
        @Test
        void retornarListaVaziaQuandoNaoExistemAlunos() {
            assertEquals(0, cobaia.listar(null).size());
        }

        @Test
        void retornarListaDeAlunosQuandoEstesExisterem() {
            setupListagemDeAlunosNoMock();
            assertEquals(3, cobaia.listar(null).size());
        }

        @ParameterizedTest @CsvSource({"2, true", "1, false"})
        void retornarListaFiltradaQdoEspecialInformado(int qtdEsperada, boolean especial) {
            setupListagemDeAlunosNoMock();
            assertEquals(qtdEsperada, cobaia.listar(especial).size());
        }
    }

    private void setupListagemDeAlunosNoMock() {
        AlunoFactory alisson = new AlunoFactory();
        mock.listagem.add(alisson.criaAluno("Aluno A", 1, true));
        mock.listagem.add(alisson.criaAluno("Aluno B", 2, false));
        mock.listagem.add(alisson.criaAluno("Aluno C", 3, true));
    }
}
