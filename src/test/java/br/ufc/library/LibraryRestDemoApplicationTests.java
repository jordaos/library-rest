package br.ufc.library;

import br.ufc.library.author.AuthorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryRestDemoApplicationTests {
    @Autowired
    AuthorRepository repository;

	@Test
	public void contextLoads() {

	}
}
