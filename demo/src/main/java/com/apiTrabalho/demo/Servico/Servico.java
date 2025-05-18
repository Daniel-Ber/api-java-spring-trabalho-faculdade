package com.apiTrabalho.demo.Servico;

import com.apiTrabalho.demo.Entidade.Entidade;
import com.apiTrabalho.demo.PessoaNaoEncontradaExcecao.PessoaNaoEncontradaExcecao;
import com.apiTrabalho.demo.Repositorio.Repositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Servico {

    private final Repositorio repositorio;

    public Servico(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Entidade criarPessoa(Entidade pessoa) {
        System.out.println("Criando pessoa: " + pessoa.getNome());
        return repositorio.save(pessoa);
    }

    public Optional<Entidade> buscarPorId(Integer id) {
        System.out.println("Buscando pessoa com id: " + id);
        return repositorio.findById(id);
    }

    public void apagarPessoa(Integer id) {
        System.out.println("Apagando pessoa com id: " + id);
        if (!repositorio.existsById(id)) {
            throw new PessoaNaoEncontradaExcecao("Pessoa não encontrada");
        }
        repositorio.deleteById(id);
    }

    public Entidade atualizarPessoa(Integer id, Entidade pessoaAtualizada) {
        System.out.println("Atualizando pessoa com id: " + id);
        Entidade pessoa = repositorio.findById(id)
                .orElseThrow(() -> new PessoaNaoEncontradaExcecao("Pessoa não encontrada"));
        pessoa.setNome(pessoaAtualizada.getNome());
        pessoa.setCpf(pessoaAtualizada.getCpf());
        pessoa.setIdade(pessoaAtualizada.getIdade());
        return repositorio.save(pessoa);
    }

    public List<Entidade> buscarPorNomeEIdade(String nome, Integer idade) {
        System.out.println("Buscando pessoas com nome iniciando com '" + nome + "' e idade maior que " + idade);
        return repositorio.findByNomeStartingWithAndIdadeGreaterThan(nome, idade);
    }

    public List<Entidade> buscarPessoasPorNomeEIdade(String nome, Integer idade) {
        System.out.println("Buscando pessoas com nome exato '" + nome + "' e idade maior que " + idade);
        return repositorio.findByNomeAndIdadeGreaterThan(nome, idade);
    }

    public List<Entidade> buscarPessoasRafaelMaiorDe18() {
        System.out.println("Buscando pessoas com nome 'Rafael' e idade maior que 18");
        return repositorio.findByNomeAndIdadeGreaterThan("Rafael", 18);
    }
}
