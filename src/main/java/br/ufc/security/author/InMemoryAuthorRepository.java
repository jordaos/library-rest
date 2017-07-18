package br.ufc.security.author;

import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by jordao on 17/07/17.
 */
@Component
public class InMemoryAuthorRepository implements AuthorRepository {
    private static final List<Author> AUTHORS = new ArrayList<>();

    static{
        AUTHORS.addAll(Arrays.asList(
                new Author(1, "Jordão", "Macedo")
        ));
    }

    @Override
    public Iterable<Author> findAll() {
        return Collections.unmodifiableCollection(AUTHORS);
    }

    @Override
    public void save(Author author){
        Author aux = getById(author.getId());
        if(aux != null){
            AUTHORS.remove(aux);
        }
        AUTHORS.add(author);
    }

    @Override
    public Author getById(int id) {
        for(Author author : AUTHORS){
            if(author.getId() == id)
                return author;
        }
        return null;
    }

    @Override
    public Author deleteAuthor(int id) {
        Author aux = getById(id);
        AUTHORS.remove(aux);
        return aux;
    }


}
