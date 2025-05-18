package com.apiTrabalho.demo.Entidade;
import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.Id;


@Entity
@Table(name = "pessoa")
public class Entidade {
    @Id
    private Integer id;
    @Column
    private String nome;
    @Column
    private String cpf;
    @Column
    private Integer idade;

    public  Entidade(){}

    public Entidade(Integer id, String nome, String cpf, Integer idade){
        this.cpf = cpf;
        this.nome = nome;
        this.id = id;
        this.idade = idade;
    }


    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
