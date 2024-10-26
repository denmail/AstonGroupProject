package Interface;

public class Book {
    private final String author;
    private final String title;
    private final int pages;

    // Приватный конструктор для паттерна Builder
    private Book(Builder builder) {
        this.author = builder.author;
        this.title = builder.title;
        this.pages = builder.pages;
    }

    // Статический класс Builder
    public static class Builder {
        private String author;
        private String title;
        private int pages;

        public Builder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setPages(int pages) {
            this.pages = pages;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

    @Override
    public String toString() {
        return "Book [Author=" + author + ", Title=" + title + ", Pages=" + pages + "]";
    }
}
