package br.ufc.security.publishers;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by jordao on 18/07/17.
 */
@Component
public class InMemoryPublisherRepository implements PublisherRepository{
    private static final List<Publisher> PUBLISHERS = new ArrayList<>();

    static{
        PUBLISHERS.addAll(Arrays.asList(
                new Publisher(1, "Editora 1")
        ));
    }

    @Override
    public Iterable<Publisher> findAll() {
        return Collections.unmodifiableCollection(PUBLISHERS);
    }

    @Override
    public void save(Publisher publisher) {
        Publisher aux = getById(publisher.getId());
        if(aux != null){
            PUBLISHERS.remove(aux);
        }
        PUBLISHERS.add(publisher);
    }

    @Override
    public Publisher getById(int id) {
        for(Publisher publisher : PUBLISHERS){
            if(publisher.getId() == id)
                return publisher;
        }
        return null;
    }

    @Override
    public Publisher deletePublisher(int id) {
        Publisher aux = getById(id);
        PUBLISHERS.remove(aux);
        return aux;
    }
}
