package br.ufc.security.pubs;

import br.ufc.security.author.Author;
import br.ufc.security.publishers.Publisher;

/**
 * Created by jordao on 18/07/17.
 */
public class Pub {
    private Integer id;
    private String titulo;
    private Author author;
    private Publisher publisher;
    private String description;
    private int tipo;//1=livro; 2=revista

    public Pub(Integer id, String titulo, Author author, Publisher publisher, String description, int tipo) {
        this.id = id;
        this.titulo = titulo;
        this.author = author;
        this.publisher = publisher;
        this.description = description;
        this.tipo = tipo;
    }

    public Pub() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
