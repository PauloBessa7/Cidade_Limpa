package com.cidade.limpa.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "ocorrencia")
public class OcorrenciaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String cidade;

    @Column(length = 100, nullable = false)
    private String bairro;

    @Column(length = 100, nullable = false)
    private String rua;

    @Column(length = 20)
    private String numero;  // Opcional

    @Column(nullable = true)
    private LocalDate dataHora;

    @PrePersist
    public void prePersist() {
        this.dataHora = LocalDateTime.now().toLocalDate();
    }

    @Column(length = 500, nullable = false)
    private String descricao;

    @Column(nullable = false)
    private int curtidas = 0;

    @Column(nullable = false)
    private boolean statusConcluido = false;

    // Construtor padrão
    public OcorrenciaModel() {}

    // Construtor completo
    public OcorrenciaModel(String cidade, String bairro, String rua, String numero,
                           LocalDate dataHora, String descricao) {
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.dataHora = dataHora;
        this.descricao = descricao;
        this.curtidas = 0;
        this.statusConcluido = false;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(int curtidas) {
        this.curtidas = curtidas;
    }

    public boolean isStatusConcluido() {
        return statusConcluido;
    }

    public void setStatusConcluido(boolean statusConcluido) {
        this.statusConcluido = statusConcluido;
    }
}
