package br.ufc.security.pubs;

/**
 * Created by jordao on 18/07/17.
 */
public interface PubRepository {
    Iterable<Pub> findAll();
    void save(Pub pub);
    Pub getById(int id);
    Pub deletePub(int id);
    Iterable<Pub> findAllPubsByAuthor(int id);
    Pub findPubByAuthor(int idAuthor, int idPub);
    Iterable<Pub> findAllPubsByPublisher(int id);
    Pub findPubByPublisher(int idPublisher, int idPub);
}
