package org.web.service.impl;
import org.web.core.exceptions.NoPublisherException;
import org.web.core.model.Book;
import org.web.core.model.Publisher;
import org.web.core.service.PublisherService;
import org.web.service.dao.PublisherDAO;

import java.sql.SQLException;
import java.util.Collection;

public class PublisherServiceImpl implements PublisherService{

    private PublisherDAO publisherDAO = null;

    public PublisherServiceImpl(PublisherDAO publisherDAO) {
        this.publisherDAO = publisherDAO;
    }

    public Publisher getPublisher(int id) throws NoPublisherException, SQLException {
        return publisherDAO.getPublisher(id);
    }

    public Publisher getPublisher(Publisher publisher) throws NoPublisherException, SQLException {
        return publisherDAO.getPublisher(publisher);
    }

    public void addPublisher(String publisherName) throws SQLException {
        publisherDAO.addPublisher(publisherName);
    }

    public Collection<Book> getAllPublisher() {
        return publisherDAO.getAllPublisher();
    }
}
