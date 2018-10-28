package com.example.corem.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_game_over.*

class GameOverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)
    }

    fun playagain (view: View) {
        val playagain = btPlayAgain
        val intent = Intent(this, PlayActivity::class.java)
        startActivity(intent)
        //finish()
    }

    fun quit2(view: View){
        val quit = btQuit2
        btQuit2.setOnClickListener {
            finish()
        }
    }
}
