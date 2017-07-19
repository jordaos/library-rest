package br.ufc.security.pubs;

import br.ufc.security.author.Author;
import br.ufc.security.publishers.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jordao on 18/07/17.
 */
public interface PubRepository extends CrudRepository<Pub, Integer>{

}
