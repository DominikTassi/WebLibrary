package org.web.core.model;

import org.web.core.exceptions.NoBookException;
import org.web.core.exceptions.WrongPieceException;

public class Stock {
    private Book book;
    private int piece;

    public Stock(Book book, int piece) throws WrongPieceException, NoBookException {
        setBook(book);
        setPiece(piece);
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) throws NoBookException {
        if (book == null)
            throw new NoBookException("No book was given");
        this.book = book;
    }

    public int getPiece() {
        return piece;
    }

    public void setPiece(int piece) throws WrongPieceException {
        if (piece < 0)
            throw new WrongPieceException("Piece can't be negative");
        this.piece = piece;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        if (piece != stock.piece) return false;
        return book.equals(stock.book);
    }

    @Override
    public int hashCode() {
        int result = book.hashCode();
        result = 31 * result + piece;
        return result;
    }
}
