package com.example.corem.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.corem.myapplication.R.id.btPlay
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }

    fun play2(view: View) {
        val ir = btPlay2
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
        finish()
    }

    //
    /*
     fun voltar(view: View) {
        val ir = btVoltar
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
        finish()
    }
     */

}
