package com.ubscuidebem.model;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="paciente")
public class Paciente {

    @Id
    private int id;
    
    @Column(name ="unidadesus")
    private String unidadeSUS;
    
    private String nome;
    
    @Column(name="datanascimento")
    private Date dataNasc;
    
    private String endereco;
    
    private String telefone;

    public Paciente(int id, String unidadeSUS, String nome, Date dataNasc, String endereco, String telefone) {
        this.id = id;
        this.unidadeSUS = unidadeSUS;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    //Construtor padrão
    public Paciente() {}

    //Getters e setters para todos os campos
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getUnidadeSUS() {
        return unidadeSUS;
    }

    public void setUnidadeSUS(String unidadeSUS) {
        this.unidadeSUS = unidadeSUS;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}