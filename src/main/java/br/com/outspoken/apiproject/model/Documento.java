package br.com.outspoken.apiproject.model;

import javax.persistence.*;
import java.time.*;

@Entity
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column
    private String nome;
    @Column
    private LocalDate data;
    @Column
    private float salario;
    @Column
    private String informacoes;

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data){
        this.data = data;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return Id;
    }

    public String getNome() {
        return nome;
    }

}
