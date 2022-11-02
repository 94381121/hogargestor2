package com.jacal.hogargestor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import com.google.android.material.snackbar.Snackbar

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        setSupportActionBar(findViewById(R.id.my_toolbar2))
        //Codigo para ejecutar en el icono que tiene signo + parte inferior derecha
        val fab:View=findViewById(R.id.fab)
        /*fab.setOnClickListener{view->
            Snackbar.make(view,R.string.txt_fab,Snackbar.LENGTH_LONG).show()
        }*///fin código
        fab.setOnClickListener { view ->
            val intent = Intent(this,ToDoMainActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity, menu)
        return super.onCreateOptionsMenu(menu)
    }
}