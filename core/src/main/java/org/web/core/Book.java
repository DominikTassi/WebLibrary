package org.web.core;

import java.util.Date;

public class Book {
    private int ISBN;
    private String name;
    private Subject subject;
    private Author author;
    private Publisher publisher;
    private Date publicationDate;
    private Nationality language;

    public Book(int ISBN, String name, Subject subject, Author author, Publisher publisher, Date publicationDate, Nationality language) {
        this.ISBN = ISBN;
        this.name = name;
        this.subject = subject;
        this.author = author;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.language = language;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setLanguage(Nationality language) {
        this.language = language;
    }

    public int getISBN(){
        return ISBN;
    }

    public String getName(){
        return name;
    }

    public Subject getSubject() {
        return subject;
    }

    public Author getAuthor() {
        return author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public Nationality getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN=" + ISBN +
                ", name='" + name + '\'' +
                ", subject=" + subject +
                ", author=" + author +
                ", publisher=" + publisher +
                ", publicationDate=" + publicationDate +
                ", language=" + language +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (ISBN != book.ISBN) return false;
        if (!name.equals(book.name)) return false;
        if (!subject.equals(book.subject)) return false;
        if (!author.equals(book.author)) return false;
        if (!publisher.equals(book.publisher)) return false;
        if (!publicationDate.equals(book.publicationDate)) return false;
        return language == book.language;
    }

    @Override
    public int hashCode() {
        int result = ISBN;
        result = 31 * result + name.hashCode();
        result = 31 * result + subject.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + publisher.hashCode();
        result = 31 * result + publicationDate.hashCode();
        result = 31 * result + language.hashCode();
        return result;
    }
}
