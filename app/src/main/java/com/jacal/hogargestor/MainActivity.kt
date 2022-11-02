package com.jacal.hogargestor

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private var edtusername: EditText? =null
    private var edtPassword: EditText? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        edtusername =findViewById(R.id.edtusername)
        edtPassword =findViewById(R.id.edtPassword)
    }
    fun onLogin(botonLogin: View) {
        var messageerrorUsername=getString(R.string.messageerrorUsername)
        var messageerrorPassword=getString(R.string.messageerrorPassword)
        var welcome=getString(R.string.welcome)
        var username: String = edtusername!!.text.toString( )
        var password: String = edtPassword!!.text.toString( )
        if(username == "user" )
        {
            if( password == "1")
            {
                val positiveButton={dialogpositivo:DialogInterface, which:Int->
                    val intent =Intent(this,WelcomeActivity::class.java)
                    startActivity(intent)
                }
                val negativeButton={_:DialogInterface,_:Int->}
              //Toast.makeText(applicationContext, "WELCOME",
               //Toast.LENGTH_LONG).show()

                val dialogpositivo = AlertDialog.Builder(this)
                    .setTitle(welcome)
                    .setMessage ("User:"+edtusername!!.text.toString())
                    .setPositiveButton("ok",positiveButton)
                    .setNegativeButton("cancelar",negativeButton)
                    .create()
                    .show()
           }
        else
        {
            //Toast.makeText(this, "Invalid password",
              //  Toast.LENGTH_SHORT).show()
            val dialog = AlertDialog.Builder(this).setTitle("ERROR!")
                .setMessage (messageerrorPassword).create().show()
        }
        }else{
            //Toast.makeText(this, "Invalid username",
              //  Toast.LENGTH_SHORT).show()
            val dialog = AlertDialog.Builder(this).setTitle("ERROR!")
                .setMessage (messageerrorUsername).create().show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun onRegister(view: View) {
        val intent =Intent(this,RegisterActivity::class.java)
        startActivity(intent)
    }
}