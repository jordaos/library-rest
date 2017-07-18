package br.ufc.security.publishers;

/**
 * Created by jordao on 18/07/17.
 */
public class Publisher {
    private Integer id;
    private String name;

    public Publisher(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Publisher() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
