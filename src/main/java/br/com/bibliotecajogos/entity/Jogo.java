package br.com.bibliotecajogos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private Integer anoPublicacao;
    private String genero;
    private String urlCapa;
    private boolean finalizado = false;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    // Construtor vazio (essencial para o JPA/Hibernate)
    public Jogo() {
    }

    // ⭐ CONSTRUTOR ADICIONADO PARA RESOLVER O ERRO! ⭐
    public Jogo(String titulo, String autor, Integer anoPublicacao, String genero, String urlCapa, boolean finalizado, Categoria categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.genero = genero;
        this.urlCapa = urlCapa;
        this.finalizado = finalizado;
        this.categoria = categoria;
    }

    // --- Getters e Setters (continuam aqui) ---
    
    public Long getId() {
        return id;
    }
    // ... resto dos seus getters e setters
}
