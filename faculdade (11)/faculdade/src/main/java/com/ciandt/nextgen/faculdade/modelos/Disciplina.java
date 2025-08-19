package com.ciandt.nextgen.faculdade.modelos;

public enum Disciplina {
    DISCIPLINA1("Nota 1"),
    DISCIPLINA2("Nota 2"),
    SOCIOLOGIA("Nota Sociologia"),
    CALCULO1("Nota Cálculo I"),
    CALCULO2("Nota Cálculo II"),
    CALCULO3("Nota Cálculo III"),
    FISICA("Nota Física"),
    BIO_ENG("Nota Bio-Engenharia"),
    DISCIPLINA3("Nota 3"),
    DISCIPLINA4("Nota 4");

    private final String nome;

    Disciplina(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
}

/*
public class Disciplina {
    public static final Disciplina DISCIPLINA1 = new Disciplina("Nota 1");
    public static final Disciplina DISCIPLINA2 = new Disciplina("Nota 2");
    public static final Disciplina SOCIOLOGIA = new Disciplina("Nota Sociologia");
    public static final Disciplina CALCULO1 = new Disciplina("Nota Cálculo I");
    public static final Disciplina CALCULO2 = new Disciplina("Nota Cálculo II");
    public static final Disciplina CALCULO3 = new Disciplina("Nota Cálculo III");
    public static final Disciplina FISICA = new Disciplina("Nota Física");
    public static final Disciplina BIO_ENG = new Disciplina("Nota Bio-Engenharia");
    public static final Disciplina DISCIPLINA3 = new Disciplina("Nota 3");
    public static final Disciplina DISCIPLINA4 = new Disciplina("Nota 4");
    private static final Disciplina[] values = {DISCIPLINA1, DISCIPLINA2, SOCIOLOGIA};

    private final String nome;

    private Disciplina(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
*/