package model;

import java.util.Objects;

public class Book implements Comparable<Book> {
    private final String name;
    private final String author;
    private final int numberOfPages;

    private Book(BookBuilder bookBuilder) {
        this.name = bookBuilder.name;
        this.author = bookBuilder.author;
        this.numberOfPages = bookBuilder.numberOfPages;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public static class BookBuilder {
        private final String name;
        private String author;
        private int numberOfPages;

        public BookBuilder(String name) {
            this.name = name;
        }

        public BookBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder setNumberOfPages(int numberOfPages) {
            this.numberOfPages = numberOfPages;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Book otherObj = (Book) obj;
        return (Objects.equals(this.name, otherObj.name) && Objects.equals(this.author, otherObj.author)
                && Objects.equals(this.numberOfPages, otherObj.numberOfPages));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, numberOfPages);
    }

    @Override
    public int compareTo(Book o) {
        if (!Objects.equals(this.name, o.name))
            return this.name.compareTo(o.name);
        else if (!Objects.equals(this.author, o.author))
            return this.author.compareTo(o.author);
        else
            return this.numberOfPages - o.numberOfPages;
    }

    @Override
    public String toString() {
        return  "{Книга} " +
                "Название: " + name +
                ", Автор: " + ((author == null) ? "не указан" : author) +
                ", Кол-во страниц: " + ((numberOfPages > 0) ? numberOfPages : "не указано");
    }
}