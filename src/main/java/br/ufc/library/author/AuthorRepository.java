package br.ufc.library.author;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Created by jordao on 17/07/17.
 */
@CrossOrigin(origins = "*")
public interface AuthorRepository extends CrudRepository<Author, Integer>{

}
