package com.ciandt.nextgen.faculdade.outros;

import com.ciandt.nextgen.faculdade.cursos.AlunoEngSoftware;
import com.ciandt.nextgen.faculdade.cursos.AlunoEstatistica;
import com.ciandt.nextgen.faculdade.cursos.AlunoFilosofia;
import com.ciandt.nextgen.faculdade.cursos.AlunoMedicina;
import com.ciandt.nextgen.faculdade.cursos.AlunoPsicologia;
import com.ciandt.nextgen.faculdade.modelos.Aluno;

public class AlunoFactory {
    public static final String MEDICINA = "Medicina";
    public static final String ENG_SOFTWARE = "EngSoftware";
    public static final String ESTATISTICA = "Estatistica";
    public static final String PSICOLOGIA = "Psicologia";
    public static final String FILOSOFIA = "Filosofia";

    public Aluno criaAluno(String nome, String nomeCurso) {
        Aluno aluno = null;
        switch (nomeCurso) {
        case MEDICINA:
            aluno = new AlunoMedicina();
            break;
        case ENG_SOFTWARE:
            aluno = new AlunoEngSoftware();
            break;
        case ESTATISTICA:
            aluno = new AlunoEstatistica();
            break;
        case PSICOLOGIA:
            aluno = new AlunoPsicologia();
            break;
        case FILOSOFIA:
            aluno = new AlunoFilosofia();
            break;
        default:
            System.err.println("Curso inválido: " + nomeCurso);
        }
        if (aluno != null) {
            aluno.setNome(nome);
        }
        return aluno;
    }

    public Aluno criaAluno(String nome, int codigoCurso) {
        String cursos[] = {MEDICINA,ENG_SOFTWARE,ESTATISTICA,PSICOLOGIA,FILOSOFIA};
        if (codigoCurso < 1 || codigoCurso > cursos.length) {
            System.err.println("Código do curso inválido: " + codigoCurso);
            return null;
        }
        return criaAluno(nome, cursos[codigoCurso-1]);
    }

    public Aluno criaAluno(String nome, int codigoCurso, boolean especial) {
        return safeSetEspecial(this.criaAluno(nome, codigoCurso), especial);
    }

    public Aluno criaAluno(String nome, String nomeCurso, boolean especial) {
        return safeSetEspecial(this.criaAluno(nome, nomeCurso), especial);
    }

    private Aluno safeSetEspecial(Aluno alisson, boolean especial) {
        if (alisson != null) {
            alisson.setEspecial(especial);
        }
        return alisson;
    }
}
