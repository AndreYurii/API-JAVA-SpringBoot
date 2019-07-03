package br.com.outspoken.apiproject.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String nome;
    private LocalDateTime data;
    private float salario;

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    private String informacoes;




    public LocalDateTime getData() {

        return LocalDateTime.of(1998, Month.DECEMBER, 12, 12,07);
    }

    public void setData(LocalDateTime data) {
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
