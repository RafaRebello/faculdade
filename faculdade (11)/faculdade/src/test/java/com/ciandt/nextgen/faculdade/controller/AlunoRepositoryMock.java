package com.ciandt.nextgen.faculdade.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.ciandt.nextgen.faculdade.modelos.Aluno;
import com.ciandt.nextgen.faculdade.outros.AlunoFactory;
import com.ciandt.nextgen.faculdade.repository.AlunoRepository;

public class AlunoRepositoryMock implements AlunoRepository {
    int contadorDeletar = 0;
    List<Aluno> listagem = new LinkedList<>();

    @Override
    public List<Aluno> findAll() {
        return listagem;
    }

    @Override
    public List<Aluno> findAll(Sort sort) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Aluno> findAllById(Iterable<Long> ids) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Aluno> List<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void flush() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public <S extends Aluno> S saveAndFlush(S entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Aluno> List<S> saveAllAndFlush(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Aluno> entities) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> ids) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAllInBatch() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Aluno getOne(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Aluno getById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Aluno getReferenceById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Aluno> List<S> findAll(Example<S> example) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Aluno> List<S> findAll(Example<S> example, Sort sort) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<Aluno> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Aluno> S save(S entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Aluno> findById(Long id) {
        return 1L == id ? Optional.of(new AlunoFactory().criaAluno("Flavio", 2)) : Optional.empty();
    }

    @Override
    public boolean existsById(Long id) {
        return 1L == id && contadorDeletar == 0;
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void deleteById(Long id) {
        if (id == 1L) {
            contadorDeletar++;
        } else {
            throw new RuntimeException("matricula não esperada: " + id);
        }
    }

    @Override
    public void delete(Aluno entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAll(Iterable<? extends Aluno> entities) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public <S extends Aluno> Optional<S> findOne(Example<S> example) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public <S extends Aluno> Page<S> findAll(Example<S> example, Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Aluno> long count(Example<S> example) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public <S extends Aluno> boolean exists(Example<S> example) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public <S extends Aluno, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Aluno> findByNome(String nome) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Aluno> findByEspecial(boolean especial) {
        //return listagem.stream().filter(a -> especial == a.getEspecial()).toList();
        List<Aluno> filtrado = new LinkedList<>();
        for (Aluno a : listagem) {
            if (especial == a.getEspecial()) {
                filtrado.add(a);
            }
        }
        return filtrado;
    }
}