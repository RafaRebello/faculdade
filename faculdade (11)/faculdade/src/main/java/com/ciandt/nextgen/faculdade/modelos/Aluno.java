package com.ciandt.nextgen.faculdade.modelos;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import static com.ciandt.nextgen.faculdade.modelos.Situacao.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "curso")
public abstract class Aluno {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long matricula;

    private String nome;

    private boolean especial = false;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)

    protected List<Nota> notas = new LinkedList<>();

    private Double media;

    private Situacao situacao;
    
    public Aluno () {
        notas.add(new Nota(this, Disciplina.DISCIPLINA1));
        notas.add(new Nota(this, Disciplina.DISCIPLINA2));
    }

    public String getNome() {
        return this.nome;
    }

    public boolean getEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
        determinaSituacao();
    }
    
    public Double getMedia() {
        return this.media;
    }

    public Situacao getSituacao() {
        return this.situacao;
    }

    private void calculaMedia() {
        double soma = 0;
        int qtdDeNotas = 0;
        for (Nota nota : notas) {
            if (nota.getValor() != null) {
                soma += nota.getValor();
                qtdDeNotas++;
            }
        }
        this.media = qtdDeNotas > 0 ? soma / qtdDeNotas : null;
    }
    
    private void determinaSituacao() {
        situacao = media >= 7 ? APROVADO :
            especial ? EM_ANALISE_PELO_CORPO_DOCENTE :
            media >= 5 ? EM_RECUPERACAO :
            REPROVADO;
    }

    void autoUpdate() {
        calculaMedia();
        determinaSituacao();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + this.nome;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }
}