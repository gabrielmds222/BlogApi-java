package com.example.BlogApi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco")
    private BigDecimal preco;

    public BigDecimal getPreco(BigDecimal preco) {
        return this.preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
