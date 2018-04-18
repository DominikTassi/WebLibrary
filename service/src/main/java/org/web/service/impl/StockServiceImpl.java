package org.web.service.impl;

import org.web.core.exceptions.NoBookException;
import org.web.core.exceptions.NoStockException;
import org.web.core.model.Book;
import org.web.core.model.Stock;
import org.web.core.service.StockService;
import org.web.service.dao.StockDAO;

import java.util.Collection;

public class StockServiceImpl implements StockService {

    private StockDAO stockDAO;

    public StockServiceImpl(StockDAO stockDAO) {
        this.stockDAO = stockDAO;
    }

    public Stock getStock(int ISBN) throws NoBookException {
        return stockDAO.getStock(ISBN);
    }

    public Stock getStock(String bookName) throws NoStockException {
        return stockDAO.getStock(bookName);
    }

    public void addStock(Stock stock) {
        stockDAO.addStock(stock);
    }

    public Collection<Stock> getAllStock() {
        return stockDAO.getAllStock();
    }
}
