package org.web.core;

public class Stock {
    private Book book;
    private int piece;

    public Stock(Book book, int piece) {
        this.book = book;
        this.piece = piece;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getPiece() {
        return piece;
    }

    public void setPiece(int piece) {
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
