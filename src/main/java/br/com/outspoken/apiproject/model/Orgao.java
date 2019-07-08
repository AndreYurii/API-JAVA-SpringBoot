package br.com.outspoken.apiproject.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
public class Orgao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column
    private String nome;

    @Column
    private LocalDate data;

    @Column
    private String informacoes;

    @Column
    private String telefone;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_orgao")
    private List<Documento> listaDocumentos;

    public String getTelefone() {
        return telefone;
    }


    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }

    public List<Documento> getListaDocumentos() {
        return listaDocumentos;
    }

    public void setListaDocumentos(List<Documento> listaDocumentos) {
        this.listaDocumentos = listaDocumentos;
    }
}