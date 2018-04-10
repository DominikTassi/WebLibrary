package org.web.core.model;

import org.web.core.exceptions.NoBirthDateException;
import org.web.core.exceptions.NoNameException;

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

    public void setName(String name) throws NoNameException {
        if(name == null || name == "")
            throw new NoNameException("No name was given");
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) throws NoBirthDateException {
        if(birth == null)
            throw new NoBirthDateException("No birthday was given");
        this.birth = birth;
    }

    public Author(int id, String name, Date birth, Nationality nationality) throws NoNameException, NoBirthDateException {
        this.id = id;
        setName(name);
        setBirth(birth);
        this.nationality = nationality;
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

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", nationality=" + nationality +
                '}';
    }
}
