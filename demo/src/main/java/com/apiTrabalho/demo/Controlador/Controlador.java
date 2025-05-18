package com.apiTrabalho.demo.Controlador;


import com.apiTrabalho.demo.DTO.DTO;
import com.apiTrabalho.demo.Entidade.Entidade;
import com.apiTrabalho.demo.Servico.Servico;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoas")
public class Controlador {

    private final Servico servico;

    public Controlador(Servico servico) {
        this.servico = servico;
    }

    @PostMapping
    public Entidade criarPessoa(@RequestBody DTO dto) {
        Entidade pessoa = new Entidade(null, dto.getNome(), dto.getCpf(), dto.getIdade());
        return servico.criarPessoa(pessoa);
    }

    @GetMapping("/{id}")
    public DTO buscarPessoaPorId(@PathVariable Integer id) {
        Entidade pessoa = servico.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com id: " + id));
        DTO dto = new DTO();
        dto.setId(pessoa.getId());
        dto.setNome(pessoa.getNome());
        dto.setCpf(pessoa.getCpf());
        dto.setIdade(pessoa.getIdade());
        return dto;
    }

    @DeleteMapping("/{id}")
    public void apagarPessoa(@PathVariable Integer id) {
        servico.apagarPessoa(id);
    }

    @PutMapping("/{id}")
    public Entidade atualizarPessoa(@PathVariable Integer id, @RequestBody DTO dto) {
        Entidade pessoaAtualizada = new Entidade(null, dto.getNome(), dto.getCpf(), dto.getIdade());
        return servico.atualizarPessoa(id, pessoaAtualizada);
    }

    @GetMapping("/buscarPorNomeIdade")
    public List<DTO> buscarPorNomeEIdade(@RequestParam String nome, @RequestParam Integer idade) {
        List<Entidade> pessoas = servico.buscarPessoasPorNomeEIdade(nome, idade);
        return pessoas.stream().map(p -> {
            DTO dto = new DTO();
            dto.setId(p.getId());
            dto.setNome(p.getNome());
            dto.setCpf(p.getCpf());
            dto.setIdade(p.getIdade());
            return dto;
        }).collect(Collectors.toList());
    }

    @GetMapping("/rafaelMaiorDe18")
    public List<DTO> buscarRafaelMaiorDe18() {
        List<Entidade> pessoas = servico.buscarPessoasRafaelMaiorDe18();
        return pessoas.stream().map(p -> {
            DTO dto = new DTO();
            dto.setId(p.getId());
            dto.setNome(p.getNome());
            dto.setCpf(p.getCpf());
            dto.setIdade(p.getIdade());
            return dto;
        }).collect(Collectors.toList());
    }
}
