package br.ufc.security.author;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by jordao on 17/07/17.
 */
public interface AuthorRepository extends CrudRepository<Author, Integer>{
    Author findById(int id);
    Author findByFirstNameAndLastName(String fistName, String LastName);
}
