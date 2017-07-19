package br.ufc.security.author;

//import br.ufc.security.pubs.Pub;
//import br.ufc.security.pubs.PubRepository;
import br.ufc.security.pubs.Pub;
import br.ufc.security.pubs.PubRepository;
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

    @Autowired
    private PubRepository repository_pub;

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
        Author author = repository.findById(id);
        if(author == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(author);
    }

    //------------------------- crete an author ------------------------
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> createAuthor(@RequestBody Author author) throws MalformedURLException, URISyntaxException{
        if(repository.findByFirstNameAndLastName(author.getFirstName(), author.getLastName()) != null)
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);

        repository.save(author);
        URL createdURL = new URL("http://localhost:8080/authors/" + author.getId().toString());
        return ResponseEntity.created(createdURL.toURI()).build();
    }

    //------------------------- Update author ------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Author> updateAuthor(@PathVariable("id") int id, @RequestBody Author author) throws MalformedURLException, URISyntaxException{
        if(repository.findById(id) == null)
            return ResponseEntity.notFound().build();
        author.setId(id);
        repository.save(author);
        return ResponseEntity.ok(author);
    }

    //------------------------- delete an author ------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Void> deleteAuthor(@PathVariable("id") int id) {
        Author author = repository.findById(id);
        if(author == null)
            return ResponseEntity.notFound().build();
        repository.delete(author);
        return ResponseEntity.noContent().build();
    }

    //------------------------- get all pubs by author ---------------------
    @RequestMapping(value = "/{id}/pubs", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody//não busca nenhuma view
    public ResponseEntity<Iterable<Pub>> queryAllPubsByAuthor(@PathVariable("id") int id){
        Author author = repository.findById(id);
        return ResponseEntity.ok(repository_pub.findByAuthor(author));
    }

    //------------------------- Retrieve a single pub by author ---------------------
    @RequestMapping(value = "/{idAuthor}/pubs/{idPub}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody//não busca nenhuma view
    public ResponseEntity<Pub> queryAllPubsByAuthor(@PathVariable("idAuthor") int idAuthor, @PathVariable("idPub") int idPub){
        Author author = repository.findById(idAuthor);
        Pub pub = repository_pub.findByIdAndAuthor(idPub, author);
        if(pub == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pub);
    }

}
