package br.ufc.security.publishers;

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
 * Created by jordao on 18/07/17.
 */

@Controller
@RequestMapping("/publishers")
public class PublisherController {
    @Autowired
    private PublisherRepository repository;

    @Autowired
    private PubRepository repository_pub;

    //------------------------- Retrieve all publishers ------------------------
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody//não busca nenhuma view
    public ResponseEntity<Iterable<Publisher>> queryAllPublishers(){
        return ResponseEntity.ok(repository.findAll());
    }

    //------------------------- Retrieve a single publisher ------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Publisher> getPublisher(@PathVariable("id") int id) {
        Publisher publisher = repository.getById(id);
        if(publisher == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(publisher);
    }

    //------------------------- crete a publisher ------------------------
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> createPublisher(@RequestBody Publisher publisher) throws MalformedURLException, URISyntaxException {
        if(repository.getById(publisher.getId()) != null)
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);

        repository.save(publisher);
        URL createdURL = new URL("http://localhost:8080/publishers/" + publisher.getId().toString());
        return ResponseEntity.created(createdURL.toURI()).build();
    }

    //------------------------- Update publisher ------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Publisher> updatePublisher(@PathVariable("id") int id, @RequestBody Publisher publisher) throws MalformedURLException, URISyntaxException{
        if(repository.getById(id) == null)
            return ResponseEntity.notFound().build();
        publisher.setId(id);
        repository.save(publisher);
        return ResponseEntity.ok(publisher);
    }

    //------------------------- delete a publisher ------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Void> deletePublisher(@PathVariable("id") int id) {
        if(repository.deletePublisher(id) == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    //------------------------- get all pubs by publisher ---------------------
    @RequestMapping(value = "/{id}/pubs", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody//não busca nenhuma view
    public ResponseEntity<Iterable<Pub>> queryAllPubsByPublisher(@PathVariable("id") int id){
        return ResponseEntity.ok(repository_pub.findAllPubsByPublisher(id));
    }

    //------------------------- Retrieve a single pub by publisher ---------------------
    @RequestMapping(value = "/{idPublisher}/pubs/{idPub}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody//não busca nenhuma view
    public ResponseEntity<Pub> queryAllPubsByPublisher(@PathVariable("idPublisher") int idPublisher, @PathVariable("idPub") int idPub){
        Pub pub = repository_pub.findPubByPublisher(idPublisher, idPub);
        if(pub == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pub);
    }
}
