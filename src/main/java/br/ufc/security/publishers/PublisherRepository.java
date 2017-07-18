package br.ufc.security.publishers;

/**
 * Created by jordao on 18/07/17.
 */
public interface PublisherRepository {
    Iterable<Publisher> findAll();
    void save(Publisher publisher);
    Publisher getById(int id);
    Publisher deletePublisher(int id);
}
