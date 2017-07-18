package br.ufc.security.pubs;

import br.ufc.security.author.Author;
import br.ufc.security.publishers.Publisher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by jordao on 18/07/17.
 */
@Component
public class InMemoryPubRepository implements PubRepository{
    private static final List<Pub> PUBS = new ArrayList<>();

    static{
        PUBS.addAll(Arrays.asList(
                new Pub(1, "Livro 1", new Author(1, "Jordão", "Macedo"), new Publisher(1, "Editora X"), "Aqui a descrição", 1)
        ));
    }

    @Override
    public Iterable<Pub> findAll() {
        return Collections.unmodifiableCollection(PUBS);
    }

    @Override
    public void save(Pub pub) {
        Pub aux = getById(pub.getId());
        if(aux != null){
            PUBS.remove(aux);
        }
        PUBS.add(pub);
    }

    @Override
    public Pub getById(int id) {
        for(Pub pub : PUBS){
            if(pub.getId() == id)
                return pub;
        }
        return null;
    }

    @Override
    public Pub deletePub(int id) {
        Pub aux = getById(id);
        PUBS.remove(aux);
        return aux;
    }

    @Override
    public Iterable<Pub> findAllPubsByAuthor(int id) {
        List<Pub> listPubsAuthor = new ArrayList<>();
        for(Pub pub : PUBS){
            if(pub.getAuthor().getId() == id)
                listPubsAuthor.add(pub);
        }
        return Collections.unmodifiableCollection(listPubsAuthor);
    }

    @Override
    public Pub findPubByAuthor(int idAuthor, int idPub) {
        for(Pub pub : PUBS){
            if(pub.getId() == idPub && pub.getAuthor().getId() == idAuthor)
                return pub;
        }
        return null;
    }

    @Override
    public Iterable<Pub> findAllPubsByPublisher(int id) {
        List<Pub> listPubsAuthor = new ArrayList<>();
        for(Pub pub : PUBS){
            if(pub.getPublisher().getId() == id)
                listPubsAuthor.add(pub);
        }
        return Collections.unmodifiableCollection(listPubsAuthor);
    }

    @Override
    public Pub findPubByPublisher(int idPublisher, int idPub) {
        for(Pub pub : PUBS){
            if(pub.getId() == idPub && pub.getPublisher().getId() == idPublisher)
                return pub;
        }
        return null;
    }
}
