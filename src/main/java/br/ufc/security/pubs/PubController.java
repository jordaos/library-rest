package br.ufc.security.pubs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by jordao on 18/07/17.
 */

@Controller
@RequestMapping("/pubs")
public class PubController {
    @Autowired
    private PubRepository repository;

    //------------------------- Retrieve all pubs ------------------------
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody//não busca nenhuma view
    public ResponseEntity<Iterable<Pub>> queryAllPubs(){
        return ResponseEntity.ok(repository.findAll());
    }

    //------------------------- crete an author ------------------------
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> createPub(@RequestBody Pub pub) throws MalformedURLException, URISyntaxException {
        repository.save(pub);
        URL createdURL = new URL("http://localhost:8080/pubs/" + pub.getId().toString());
        return ResponseEntity.created(createdURL.toURI()).build();
    }

    //------------------------- Retrieve a single pub ------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Pub> getPub(@PathVariable("id") int id) {
        Pub pub = repository.findById(id);
        if(pub == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pub);
    }

    //------------------------- Update pub ------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Pub> updatePub(@PathVariable("id") int id, @RequestBody Pub pub) throws MalformedURLException, URISyntaxException{
        if(repository.findById(id) == null)
            return ResponseEntity.notFound().build();

        pub.setId(id);
        repository.save(pub);
        return ResponseEntity.ok(pub);
    }

    //------------------------- delete an pub ------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Void> deleteAuthor(@PathVariable("id") int id) {
        Pub pub = repository.findById(id);
        if(pub == null)
            return ResponseEntity.notFound().build();
        repository.delete(pub);
        return ResponseEntity.noContent().build();
    }

}
