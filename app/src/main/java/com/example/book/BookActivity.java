package com.example.book;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    public static final String BOOK_ID_KEY = "bookId";
    public static final String URL = "url";

    private TextView txtBookName,txtAuthor,txtPages,txtDescription;
    private Button btnAddToWantToRead,btnAddToAlreadyRead,btnAddToCurrentlyReading,btnAddToFavorites;
    private ImageView bookImage;
    private TextView btnBookLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();

        Intent intent = getIntent();
        if (null != intent)
        {
            int bookId = intent.getIntExtra(BOOK_ID_KEY,-1);
            if (bookId != -1)
            {
                Book incomingBook = Utils.getInstance().getBookById(bookId);
                    if (null != incomingBook)
                    {
                        setData(incomingBook);
                        handleAlreadyRead(incomingBook);
                        handleCurrentlyReadingBooks(incomingBook);
                        handleWantToReadBooks(incomingBook);
                        handleFavoriteBooks(incomingBook);

                        btnBookLink.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent moreInfo = new Intent(BookActivity.this,WebsiteActivity.class);
                                moreInfo.putExtra(URL,incomingBook.getBookLink());
                                startActivity(moreInfo);
                            }
                        });
                    }

            }

        }



    }

    private void handleWantToReadBooks(final Book book) {
        ArrayList<Book> wantToReadBooks = Utils.getInstance().getWantToReadBooks();
        Boolean alreadyExists = false;
        for (Book b : wantToReadBooks) {
            if (b.getId() == book.getId()) {
                alreadyExists = true;
            }
        }

        if (alreadyExists) {
            btnAddToWantToRead.setEnabled(false);
        } else {
            btnAddToWantToRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Utils.getInstance().addToWantToRead(book)) {
                        Toast.makeText(BookActivity.this, "Book added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, WantToReadActivity.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(BookActivity.this, "failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleCurrentlyReadingBooks(Book book) {
        ArrayList<Book> currentlyReadingBooks = Utils.getInstance().getCurrentlyReadingBooks();
        Boolean alreadyExists = false;
        for (Book b : currentlyReadingBooks) {
            if (b.getId() == book.getId()) {
                alreadyExists = true;
            }
        }

        if (alreadyExists) {
            btnAddToCurrentlyReading.setEnabled(false);
        } else {
            btnAddToCurrentlyReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Utils.getInstance().addToCurrentlyReading(book)) {
                        Toast.makeText(BookActivity.this, "Book added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, CurrentlyReadingActivity.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(BookActivity.this, "failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleFavoriteBooks(Book book) {
        ArrayList<Book> favoriteBooks = Utils.getInstance().getFavoriteBooks();
        Boolean alreadyExists = false;
        for (Book b : favoriteBooks) {
            if (b.getId() == book.getId()) {
                alreadyExists = true;
            }
        }

        if (alreadyExists) {
            btnAddToFavorites.setEnabled(false);
        } else {
            btnAddToFavorites.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Utils.getInstance().addToFavorites(book)) {
                        Toast.makeText(BookActivity.this, "Book added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, FavoriteBooksActivity.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(BookActivity.this, "failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    /**
     * Add book to already read ArrayList , enable/disable button
     * @param book
     */

   private void handleAlreadyRead(Book book) {
       ArrayList<Book> alreadyReadBooks = Utils.getInstance().getAlreadyReadBooks();
       Boolean alreadyExists = false;
       for (Book b : alreadyReadBooks) {
           if (b.getId() == book.getId()) {
               alreadyExists = true;
           }
       }

       if (alreadyExists) {
           btnAddToAlreadyRead.setEnabled(false);
       } else {
           btnAddToAlreadyRead.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if (Utils.getInstance().addToAlreadyRead(book)) {
                       Toast.makeText(BookActivity.this, "Book added", Toast.LENGTH_SHORT).show();
                       Intent intent = new Intent(BookActivity.this, AlreadyReadBookActivity.class);
                       startActivity(intent);

                   } else {
                       Toast.makeText(BookActivity.this, "failed", Toast.LENGTH_SHORT).show();
                   }
               }
           });
       }
   }

    private void setData(Book book) {
        txtBookName.setText((book.getName()));
        txtAuthor.setText(book.getAuthor());
        txtPages.setText(String.valueOf(book.getPages()));
        txtDescription.setText((book.getLongDescr()));
        Glide.with(this)
                .asBitmap().load(book.getImageUrl())
                .into(bookImage);
    }

    private void initViews()
    {
        txtAuthor = findViewById(R.id.txtAuthorName);
        txtBookName = findViewById(R.id.txtBookname);
        txtDescription= findViewById(R.id.txtDescription);
        txtPages = findViewById(R.id.txtPages);

        btnAddToAlreadyRead= findViewById(R.id.btnAddToAlreadyRead);
        btnAddToCurrentlyReading = findViewById(R.id.btnAddToCurrentlyReading);
        btnAddToFavorites = findViewById(R.id.btnAddToFavorites);
        btnAddToWantToRead = findViewById(R.id.btnAddToWishlist);

        bookImage = findViewById(R.id.imgBook);

        btnBookLink = findViewById(R.id.bookLink);
    }

}