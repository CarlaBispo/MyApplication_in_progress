package com.example.corem.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private val SPLASH_DISPLAY_LENGTH = 5500L
    lateinit var ivLogo: ImageView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ivLogo = findViewById(R.id.ivLogo)
        carregar()

    }

    private fun carregar(){
        val anim = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.anim_spash)
        //anim.reset()
        ivLogo.setAnimation(anim);
        ivLogo.startAnimation(anim)

        Handler().postDelayed({
            val intent = Intent(this@MainActivity, MenuActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            this.finish()

        },SPLASH_DISPLAY_LENGTH)

    }

}
