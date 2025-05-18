package com.apiTrabalho.demo.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.apiTrabalho.demo.DTO.DTO;
import com.apiTrabalho.demo.Entidade.Entidade;
import com.apiTrabalho.demo.Repositorio.Repositorio;

@RestController
public class Controlador {

    @Autowired
    private Repositorio repositorio;

    @PostMapping
    public Entidade criarPessoa(@RequestBody DTO pessoaDto){
        Entidade pessoa = new Entidade(
                pessoaDto.getId(),
                pessoaDto.getNome(),
                pessoaDto.getCpf(),
                pessoaDto.getIdade()
        );
        return repositorio.save(pessoa);
    }

    @GetMapping("/{id}")
    public DTO buscaPorId(@PathVariable Integer id){
        Entidade pessoa = repositorio.findById(id).orElse(null);
        if (pessoa == null){
            throw new RuntimeException("Pessoa não encontrada com id: " + id);
        }
        DTO dto = new DTO();
        dto.setId(pessoa.getId());
        dto.setNome(pessoa.getNome());
        dto.setCpf(pessoa.getCpf());
        dto.setIdade(pessoa.getIdade());
        return dto;
    }
}

