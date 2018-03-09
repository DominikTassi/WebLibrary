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
}
