package org.web.core;

import java.util.Date;

public class Author {
    private int id;
    private String name;
    private Date birth;
    private Nationality nationality;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (id != author.id) return false;
        if (!name.equals(author.name)) return false;
        if (!birth.equals(author.birth)) return false;
        return nationality == author.nationality;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + birth.hashCode();
        result = 31 * result + nationality.hashCode();
        return result;
    }
}
