package br.ufc.security.pubs;

import br.ufc.security.author.Author;
import br.ufc.security.publishers.Publisher;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created by jordao on 18/07/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PubController.class)
public class PubControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PubRepository repository;

    @Test
    public void queryAllPubs() throws Exception {
        /*List<Pub> pubs = new ArrayList<Pub>();
        pubs.add(
            new Pub(1, "livro", new Author(1, "Jordão", "Macedo"), new Publisher(1, "editora"), "desc", 1)
        );*/

        mockMvc.perform(MockMvcRequestBuilders.get("/pubs").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1))).andDo(print());
    }

    @Test
    @Ignore
    public void createPub() throws Exception {
    }

    @Test
    @Ignore
    public void getPub() throws Exception {
    }

    @Test
    @Ignore
    public void updatePub() throws Exception {
    }

    @Test
    @Ignore
    public void deleteAuthor() throws Exception {
    }

}