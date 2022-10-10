package com.ciandt.nextgen.faculdade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciandt.nextgen.faculdade.modelos.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    List<Aluno> findByNome(String nome);

    List<Aluno> findByEspecial(boolean especial);
}
