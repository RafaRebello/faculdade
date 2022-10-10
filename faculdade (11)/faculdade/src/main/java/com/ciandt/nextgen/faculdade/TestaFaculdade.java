package com.ciandt.nextgen.faculdade;

import java.util.ArrayList;
import java.util.List;

import com.ciandt.nextgen.faculdade.modelos.Aluno;
import com.ciandt.nextgen.faculdade.modelos.Nota;
import com.ciandt.nextgen.faculdade.outros.AlunoFactory;
import com.ciandt.nextgen.faculdade.outros.PerguntasUtil;

public class TestaFaculdade {
    public static void main(String[] args) {
        perguntasPara1Aluno();
        // criarMuitosAlunos();
    }

    public static List<Aluno> criarMuitosAlunos() {
        String nomes[] = {"Pedro", "River", "Caio", "Gisele"};
        int cursos[] = {2, 10, 3, 1};
        boolean especial[] = {false, true, true, false};
        double notas[][] = {
            {7.0,5,4,3,2,1,10}, //Pedro EngSoftware 7 notas
            {0.0},              //River bugado
            {4.5,5,6,7,8,9},    //Caio estatistica 6 notas
            {6.5,7,8,9}         //Gisele medicina 4 notas
        };
        
        List<Aluno> alunos = new ArrayList<>();
        AlunoFactory fabricaAlunos = new AlunoFactory();

        for (int i = 0; i < nomes.length; i++) {
            Aluno alunoCriado = fabricaAlunos.criaAluno(
                nomes[i], cursos[i], especial[i]);
            if (alunoCriado != null) {
                List<Nota> patricia = alunoCriado.getNotas();
                double notasDeUmAluno[] = notas[i];
                for (int j = 0; j < notasDeUmAluno.length; j++) {
                    Nota samuel = patricia.get(j);
                    samuel.setValor(notasDeUmAluno[j]);
                }
                alunos.add(alunoCriado);
            } else {
                System.err.println("Erro ao criar aluno: " + nomes[i]);
            }
        }

        System.out.println("Quantidade de alunos criados com sucesso: " + alunos.size());
        for (Aluno a : alunos) {
            String textoEsp = a.getEspecial() ? " - especial" : "";
            System.out.println(a + textoEsp);
        }
        return alunos;
    }

    public static void perguntasPara1Aluno() {
        System.out.println("Calculadora de media de alunos!");
        
        String nome = PerguntasUtil.perguntaTexto("Digite o Nome do Aluno: ");
        
        int tipo = PerguntasUtil.perguntaOpcao(
            "Qual o curso do aluno? (1 = Medicina, 2 = Engenharia de Software, 3 = Estatística, 4 = Psicologia, 5 = Filosofia)");
        Aluno aluno = new AlunoFactory().criaAluno(nome, tipo);

        if ( aluno != null ) {
            String respostaEspecial = PerguntasUtil.perguntaTexto("O aluno é especial? (Sim/Não)");
            Boolean especial = null;
            if (respostaEspecial.equalsIgnoreCase("sim") || respostaEspecial.equalsIgnoreCase("s")) {
                especial = true;
            } else if (respostaEspecial.equalsIgnoreCase("não")
                    || respostaEspecial.equalsIgnoreCase("n")
                    || respostaEspecial.equalsIgnoreCase("nao")) {
                especial = false;
            } else {
                System.out.println("Resposta inválida!");
            }

            if (especial != null) {
                aluno.setEspecial(especial);
                PerguntasUtil.perguntaNotas(aluno);
                
                System.out.println("O(A) aluno(a) " + aluno.getNome()
                        + " tem média " + aluno.getMedia()
                        + " e está " + aluno.getSituacao());
            }
        }
        System.out.println("Encerrando sistema.");
    }
}