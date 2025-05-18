package com.apiTrabalho.demo.Entidade;
import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.Id;

@Data
@Entity
@Table(name = "pessoa")
public class Entidade {
    @Id
    private Integer id;
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nome;
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
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

}
