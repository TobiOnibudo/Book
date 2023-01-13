package com.example.book

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private lateinit var btnAllBooks: Button
    private lateinit var btnAlreadyRead: Button
    private lateinit var btnWantToRead: Button
    private lateinit var btnCurrentlyReading: Button
    private lateinit var btnFavorite: Button
    private lateinit var btnAbout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        btnAllBooks.setOnClickListener {
            var intent: Intent = Intent(this, AllBooksActivity::class.java)
            startActivity(intent)
        }

        btnAlreadyRead.setOnClickListener {
            var intent: Intent = Intent(
                this,
                AlreadyReadBookActivity::class.java
            )
            startActivity(intent)
        }
        btnWantToRead.setOnClickListener {
            var intent: Intent = Intent(
                this,
                WantToReadActivity::class.java
            )
            startActivity(intent)
        }
        btnFavorite.setOnClickListener {
            var intent: Intent = Intent(
                this,
                FavoriteBooksActivity::class.java
            )
            startActivity(intent)
        }
        btnCurrentlyReading.setOnClickListener {
            var intent: Intent = Intent(
                this,
                CurrentlyReadingActivity::class.java
            )
            startActivity(intent)
        }


        btnAbout.setOnClickListener {
           val builder = AlertDialog.Builder(this)
            builder.setTitle(getString(R.string.app_name))
            builder.setMessage("Designed and Developed by Tobi Onibudo with reference and inspiration from freeCodeCamp (instructor Meisam)\n"+
            " Please check out my other projects on my github by clicking the Visit button \n Thank you.")
            builder.setNegativeButton("Dismiss",DialogInterface.OnClickListener { dialog, i ->  })
            builder.setPositiveButton("Visit",DialogInterface.OnClickListener { dialog, i ->
                //TODO : Show the website
                 var intent =  Intent(this,WebsiteActivity::class.java);
                intent.putExtra("url","https://google.com/")
                startActivity(intent)
            })
            builder.create().show()
        }

        Utils.getInstance();

    }

    private fun initViews() {
        btnAllBooks = findViewById(R.id.btnAllBooks)
        btnAlreadyRead = findViewById(R.id.btnAlreadyRead)
        btnWantToRead = findViewById(R.id.btnWantToRead)
        btnCurrentlyReading = findViewById(R.id.btnCurrentlyReading)
        btnFavorite = findViewById(R.id.btnFavorite)
        btnAbout = findViewById(R.id.btnAbout)
    }
}