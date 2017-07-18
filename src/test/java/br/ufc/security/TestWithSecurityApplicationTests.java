package br.ufc.security;

import br.ufc.security.author.Author;
import br.ufc.security.author.AuthorController;
import br.ufc.security.author.AuthorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestWithSecurityApplicationTests {
    @Autowired
    AuthorController controller;

    @Autowired
    AuthorRepository repository;

	@Test
	public void contextLoads() {

	}
}
