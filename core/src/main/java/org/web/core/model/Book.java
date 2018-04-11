package org.web.core.model;

import org.web.core.exceptions.*;

import java.util.Date;

public class Book {
    private int ISBN;
    private String name;
    private Subject subject;
    private Author author;
    private int price;
    private Publisher publisher;
    private Date publicationDate;
    private Nationality language;

    public Book(int ISBN, String name, Subject subject, Author author, int price, Publisher publisher, Date publicationDate, Nationality language) throws NoPublicationDateException, NoPublisherException, NoAuthorException, NoSubjectException, NoNameException, WrongISBNException, WrongPriceException {
        setISBN(ISBN);
        setName(name);
        setSubject(subject);
        setPrice(price);
        setAuthor(author);
        setPublisher(publisher);
        setPublicationDate(publicationDate);
        this.language = language;

    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) throws WrongISBNException {
        if (ISBN < 0)
            throw new WrongISBNException("ISBN can't be negative");
        this.ISBN = ISBN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws NoNameException{
        if (name == null || name == "")
            throw new NoNameException("No name was given");
        this.name = name;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) throws NoSubjectException {
        if (subject == null)
            throw new NoSubjectException("No subject was given");
        this.subject = subject;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) throws NoAuthorException {
        if (author == null)
            throw new NoAuthorException("No author was given");
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) throws NoPublisherException {
        if (publisher == null)
            throw new NoPublisherException("No publisher was given");
        this.publisher = publisher;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) throws NoPublicationDateException {
        if (publicationDate == null)
            throw new NoPublicationDateException("No publication date was given");
        this.publicationDate = publicationDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) throws WrongPriceException {
        if(price < 0)
            throw new WrongPriceException("Price can't be negative");
        this.price = price;
    }

    public Nationality getLanguage() {
        return language;
    }

    public void setLanguage(Nationality language) {
        this.language = language;
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
