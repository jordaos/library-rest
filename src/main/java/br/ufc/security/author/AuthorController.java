package br.ufc.security.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by jordao on 17/07/17.
 */

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository repository;

    //------------------------- Retrieve all authors ------------------------
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody//não busca nenhuma view
    public ResponseEntity<Iterable<Author>> queryAllAuthors(){
        return ResponseEntity.ok(repository.findAll());
    }

    //------------------------- Retrieve a single author ------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Author> getAuthor(@PathVariable("id") int id) {
        Author author = repository.getById(id);
        if(author == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(author);
    }

    //------------------------- crete an author ------------------------
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> createAuthor(@RequestBody Author author) throws MalformedURLException, URISyntaxException{
        if(repository.getById(author.getId()) != null)
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);

        repository.save(author);
        URL createdURL = new URL("http://localhost:8080/authors/" + author.getId().toString());
        return ResponseEntity.created(createdURL.toURI()).build();
    }

    //------------------------- Update author ------------------------
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author) throws MalformedURLException, URISyntaxException{
        if(repository.getById(author.getId()) == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        repository.save(author);
        return ResponseEntity.ok(author);
    }

    //------------------------- delete an author ------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Void> deleteAuthor(@PathVariable("id") int id) {
        if(repository.deleteAuthor(id) == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
