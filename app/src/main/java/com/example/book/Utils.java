package com.example.book;

import java.util.ArrayList;

public class Utils {
    private static Utils instance;
    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> favoriteBooks;
    private static ArrayList<Book> alreadyReadBooks;


    public Utils() {
        if (null == allBooks) {
            allBooks = new ArrayList<>();
            initData();
        }
        if (null == wantToReadBooks) {
            wantToReadBooks = new ArrayList<>();
        }
        if (null == currentlyReadingBooks) {
            currentlyReadingBooks = new ArrayList<>();
        }
        if (null == favoriteBooks) {
            favoriteBooks = new ArrayList<>();
        }
        if (null == alreadyReadBooks) {
            alreadyReadBooks = new ArrayList<>();
        }
    }

    private void initData() {
        //TODO:Add initial data
        allBooks.add(new Book(1,"1Q84","Haruki Murakami",1350,"https://images-na.ssl-images-amazon.com/images/I/71bryzuxljL.jpg",
                "A work of maddening brilliance","Long Description","https://www.goodreads.com/book/show/10357575-1q84"));
        allBooks.add(new Book(2,"The Myth of Sisyphus","Albert Camus",250,"https://m.media-amazon.com/images/I/51SM+Bv+WeL.jpg","One of the most influenftial work of the century,this is crucial exposition of existentialist thoughts",
                "Long Description",""));
    }

    public static synchronized Utils getInstance() {
        if (null != instance) {
            return instance;
        } else {
            instance = new Utils();
            return instance;
        }

    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getFavoriteBooks() {
        return favoriteBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public Book getBookById(int id)
    {
        for (Book book : allBooks){
            if (book.getId() == id)
            {
                return book;
            }
        }
        return null;
    }

    public boolean addToAlreadyRead(Book book){
        return alreadyReadBooks.add(book);
    }

    public boolean addToWantToRead(Book book){
        return wantToReadBooks.add(book);
    }
    public boolean addToCurrentlyReading(Book book)
    {
        return currentlyReadingBooks.add(book);
    }
    public boolean addToFavorites(Book book)
    {
        return favoriteBooks.add(book);
    }
    public boolean removeFromAlreadyRead(Book book)
    {
        return alreadyReadBooks.remove(book);
    }

    public boolean removeFromWantToRead(Book book)
    {
        return wantToReadBooks.remove(book);
    }
    public boolean removeFromCurrentlyReading(Book book)
    {
        return currentlyReadingBooks.remove(book);
    }
    public boolean removeFromFavorite(Book book)
    {
        return favoriteBooks.remove(book);
    }

}
