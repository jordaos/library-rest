package br.ufc.library.pubs;

import br.ufc.library.publishers.Publisher;
import br.ufc.library.author.Author;
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
    private String title;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(length=2000000)
    private byte[] image;

    @ManyToOne
    private Author author;
    @ManyToOne
    private Publisher publisher;
    private String description;

    @Enumerated(EnumType.ORDINAL)
    private PubType type;
}
