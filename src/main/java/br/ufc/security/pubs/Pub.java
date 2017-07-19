package br.ufc.security.pubs;

import br.ufc.security.author.Author;
import br.ufc.security.publishers.Publisher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by jordao on 18/07/17.
 */

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pub {
    @Id
    @GeneratedValue
    private Integer id;
    private String titulo;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Publisher publisher;
    private String description;

    @Enumerated(EnumType.ORDINAL)
    private PubType type;
}
