package br.ufc.library;

import br.ufc.library.author.Author;
import br.ufc.library.publishers.Publisher;
import br.ufc.library.pubs.Pub;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RepositoryConfiguration extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Author.class);
        config.exposeIdsFor(Publisher.class);
        config.exposeIdsFor(Pub.class);
    }
}