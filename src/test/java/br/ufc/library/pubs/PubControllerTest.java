package br.ufc.library.pubs;

import br.ufc.library.author.Author;
import br.ufc.library.publishers.Publisher;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created by jordao on 18/07/17.
 */
@RunWith(SpringRunner.class)
public class PubControllerTest {
    /*@Autowired
    private MockMvc mvc;

    @MockBean
    private PubRepository repository;

    @Autowired
    ObjectMapper objectMapper;

    private Pub pub1;
    private Pub pub2;

    private List<Pub> pubs;

    @Before
    public void prepare() {
         this.pub1 = new Pub(
                1,
                "livro",
                new Author(1, "Jordão", "Macedo", null),
                new Publisher(1, "editora", null),
                "desc",
                PubType.LIVRO
         );
        this.pub2 = new Pub(
                2,
                "revista X",
                new Author(1, "Jordão", "Macedo", null),
                new Publisher(1, "editora", null),
                "description of magazine",
                PubType.REVISTA
        );
        this.pubs = new ArrayList<Pub>();
        this.pubs.add(this.pub1);
    }

    @Test
    @Ignore
    public void queryAllPubs() throws Exception {
        given(repository.findAll()).willReturn(this.pubs);
        mvc.perform(get("/pubs").accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

        //mvc.perform(MockMvcRequestBuilders.get("/pubs").accept(MediaType.APPLICATION_JSON))
        //        .andExpect(jsonPath("$", hasSize(3))).andDo(print());
    }

    @Test
    @Ignore
    public void createPub() throws Exception {
        mvc.perform(post("/pubs")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(this.pub2))
        ).andExpect(status().isCreated());
        this.pubs.add(this.pub2);
    }

    @Test
    public void getPub() throws Exception {
        given(repository.findOne(1)).willReturn(this.pub1);

        mvc.perform(get("/pubs/1").accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("livro")))
                .andExpect(jsonPath("$.description", is("desc")));
    }

    @Test
    @Ignore
    public void updatePub() throws Exception {
    }

    @Test
    @Ignore
    public void deleteAuthor() throws Exception {
    }
*/
}