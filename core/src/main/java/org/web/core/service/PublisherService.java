package org.web.core.service;

import org.web.core.exceptions.NoPublisherException;
import org.web.core.model.Book;
import org.web.core.model.Publisher;

import java.sql.SQLException;
import java.util.Collection;

public interface PublisherService {
    public Publisher getPublisher(int id) throws NoPublisherException, SQLException;
    public Publisher getPublisher(Publisher publisher) throws NoPublisherException, SQLException;

    public void addPublisher(String publisherName) throws SQLException;
    public Collection<Book> getAllPublisher();
}
