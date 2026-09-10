package com.miguelkrsoul.livroapi.model;

import jakarta.persistence.*;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titulo;
    private String autor;
    private String capaUrl;
    
    @Column(length = 2000)
    private String descricao;
    
    @Column(length = 10000)
    private String conteudo;

    // Construtor vazio
    public Livro() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getCapaUrl() { return capaUrl; }
    public void setCapaUrl(String capaUrl) { this.capaUrl = capaUrl; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getConteudo() { return conteudo; }
    public void setConteudo(String conteudo) { this.conteudo = conteudo; }
}
