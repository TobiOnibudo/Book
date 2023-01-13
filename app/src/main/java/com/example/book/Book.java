package com.example.book;

public class Book{
    private int id;
    private String name;
    private String author;
    private int pages;
    private String imageUrl;                                            
    private String shortDescr;
    private String longDescr;                                           
    private boolean isExpanded;                                         
    private String bookLink;
           


     public Book(int id, String name, String author, int pages, String imageUrl, String shortDescr, String longDescr, String bookLink) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.imageUrl = imageUrl;
        this.shortDescr = shortDescr;
        this.longDescr = longDescr;
        this.isExpanded = false;
        this.bookLink = bookLink;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getShortDescr() {
        return shortDescr;
    }

    public String getLongDescr() {
        return longDescr;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setShortDescr(String shortDescr) {
        this.shortDescr = shortDescr;
    }

    public void setLongDescr(String longDescr) {
        this.longDescr = longDescr;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", imageUrl='" + imageUrl + '\'' +
                ", shortDescr='" + shortDescr + '\'' +
                ", longDescr='" + longDescr + '\'' +
                '}';
    }

    public String getBookLink() {
        return bookLink;
    }

    public void setBookLink(String bookLink) {
        this.bookLink = bookLink;
    }
}
