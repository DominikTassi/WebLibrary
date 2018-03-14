package org.web.core.service;

import org.web.core.exceptions.NoBookException;
import org.web.core.exceptions.NoStockException;
import org.web.core.model.Book;
import org.web.core.model.Stock;

import java.util.Collection;

public interface StockService {
    public Stock getStock(Book book) throws NoBookException;
    public Stock getStock(Stock stock) throws NoStockException;

    public void addStock(Stock stock);
    public Collection<Stock> getAllStock();
}
