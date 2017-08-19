package br.ufc.library.pubs;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Created by jordao on 18/07/17.
 */
@CrossOrigin(origins = "*")
public interface PubRepository extends CrudRepository<Pub, Integer>{

}
