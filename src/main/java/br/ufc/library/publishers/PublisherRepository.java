package br.ufc.library.publishers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Created by jordao on 18/07/17.
 */
@CrossOrigin(origins = "*")
public interface PublisherRepository extends CrudRepository<Publisher, Integer>{

}
