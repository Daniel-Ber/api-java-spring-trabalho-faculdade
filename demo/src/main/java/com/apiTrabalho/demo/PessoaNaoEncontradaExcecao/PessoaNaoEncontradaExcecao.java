package com.apiTrabalho.demo.PessoaNaoEncontradaExcecao;


public class PessoaNaoEncontradaExcecao extends RuntimeException {
    public PessoaNaoEncontradaExcecao(String mensagem) {
        super(mensagem);
    }
}

