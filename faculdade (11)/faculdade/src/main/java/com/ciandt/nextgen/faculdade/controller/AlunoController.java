package com.ciandt.nextgen.faculdade.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ciandt.nextgen.faculdade.controller.dto.AlunoDetalhesDto;
import com.ciandt.nextgen.faculdade.controller.dto.AlunoDto;
import com.ciandt.nextgen.faculdade.controller.dto.AlunoForm;
import com.ciandt.nextgen.faculdade.controller.dto.AlunoUpdateForm;
import com.ciandt.nextgen.faculdade.modelos.Aluno;
import com.ciandt.nextgen.faculdade.repository.AlunoRepository;

@RestController @RequestMapping("/alunos")
public class AlunoController {

    AlunoRepository antonio;

    public AlunoController(AlunoRepository repo) {
        this.antonio = repo;
    }
    
    @GetMapping("/{matricula}")
    public ResponseEntity<AlunoDetalhesDto> detalhar(@PathVariable Long matricula) {
        Optional<Aluno> joao = antonio.findById(matricula);
        return joao.isPresent() ?
            ResponseEntity.ok(new AlunoDetalhesDto(joao.get())) :
            ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<AlunoDto> listar(Boolean especial) {
        // return AlunoDto.converter(TestaFaculdade.criarMuitosAlunos());
        return AlunoDto.converter(
            especial == null ? antonio.findAll() : antonio.findByEspecial(especial));
    }

    @PostMapping @Transactional
    public ResponseEntity<AlunoDto> cadastrar(@RequestBody @Valid AlunoForm emiko, UriComponentsBuilder uriBuilder) {
        Aluno edmar = antonio.save(emiko.converter());
        URI uri = uriBuilder.path("/alunos/{matricula}").buildAndExpand(edmar.getMatricula()).toUri();
        return ResponseEntity.created(uri).body(new AlunoDto(edmar));
    }

    @PutMapping("/{matricula}") @Transactional
    public ResponseEntity<AlunoDetalhesDto> atualizar(@PathVariable Long matricula, @RequestBody @Valid AlunoUpdateForm alisson) {
        Optional<Aluno> samuel = antonio.findById(matricula);
        if (samuel.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        alisson.atualizar(samuel.get());
        return ResponseEntity.ok(new AlunoDetalhesDto(samuel.get()));
    }

    @DeleteMapping("/{matricula}") @Transactional
    public ResponseEntity<?> deletar(@PathVariable long matricula) {
        if (antonio.existsById(matricula)) {
            antonio.deleteById(matricula);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

/*
Fazendo um POST no Powershell
    Invoke-WebRequest -UseBasicParsing http://localhost:8080/alunos -ContentType "application/json" -Method POST -Body '{"nome":"Huandy","especial":true,"curso":"Filosofia"}'
Fazendo um POST com cUrl (Linux)
    curl -X POST localhost:8080/alunos -H 'Content-Type: application/json' --data '{"nome":"Patricia","especial":true,"codigoCurso":5,"notas":[{"disciplina":"Nota Sociologia","valor":6.5},{"disciplina":"Nota 1", "valor":7.5}]}'
*/