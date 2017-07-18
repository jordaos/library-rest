package br.ufc.security.author;

/**
 * Created by jordao on 17/07/17.
 */
public interface AuthorRepository {
    Iterable<Author> findAll();
    void save(Author author);
    Author getById(int id);
    Author deleteAuthor(int id);
}
