package com.example.corem.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

    }

    fun play(view:View){
        val play =  btPlay
        val intent = Intent(this, PlayActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun score(view:View){
        val score =  btScore
        val intent = Intent(this, ScoreActivity::class.java)
        startActivity(intent)
        finish()
    }


    fun about(view:View){
        val about =  btAbout
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun quit(view: View){
        val quit = btQuit
        btQuit.setOnClickListener {
            finish()
        }
    }
}
