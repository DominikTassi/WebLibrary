package org.web.service.dao;

import org.web.core.exceptions.NoPublisherException;
import org.web.core.model.Book;
import org.web.core.model.Publisher;

import java.util.Collection;

public interface PublisherDAO {
    public Publisher getPublisher(int id) throws NoPublisherException;
    public Publisher getPublisher(Publisher publisher) throws NoPublisherException;

    public void addPublisher(Publisher publisher);
    public Collection<Book> getAllPublisher();
}
