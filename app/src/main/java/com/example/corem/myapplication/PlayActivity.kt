package com.example.corem.myapplication

import android.content.Intent
import android.media.JetPlayer
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_play.*
import java.util.Random

class PlayActivity : AppCompatActivity() {

    private var numeroAleatorio: Random? = null

    var vitorias: Int = 0
    var empate: Int = 0
    var vidas = 3

    private val AMARELO = 1
    private val AZUL = 2
    private val ROSA = 3


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        numeroAleatorio = Random()

        btAmarelo.setOnClickListener {
            ivJogadaPlayer!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.poke_amarelo))
            realizarJogada(AMARELO)
        }


        btAzul.setOnClickListener {
            ivJogadaPlayer!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.poke_azul))
            realizarJogada(AZUL)
        }


        btRosa.setOnClickListener {
            ivJogadaPlayer!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.poke_rosa))
            realizarJogada(ROSA)
        }
    }

    private fun validaVidas() {
        if (vidas == 0) {
            val intent = Intent(this, GameOverActivity::class.java)
            intent.putExtra("Hi-Score", vitorias)
            startActivity(intent)
            finish()
        }
    }


    //passar valor da pontuacao pra tela gameover



    // fim

    private fun realizarJogada(jogadaPlayer: Int) {

        val player = MediaPlayer.create(this, R.raw.spell_00)
        player.start()

        val jogadaBot = numeroAleatorio!!.nextInt(3) + 1
        when (jogadaBot) {

            AMARELO -> {
                ivJogadaBot!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.poke_amarelo))
                when (jogadaPlayer) {
                    AZUL -> venceu()
                    AMARELO -> empatou()
                    ROSA -> perdeu()
                }
            }
            AZUL -> {
                ivJogadaBot!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.poke_azul))
                when (jogadaPlayer) {
                    AZUL -> empatou()
                    AMARELO -> perdeu()
                    ROSA -> venceu()
                }
            }
            ROSA -> {
                ivJogadaBot!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.poke_rosa))
                when (jogadaPlayer) {
                    AZUL -> perdeu()
                    AMARELO -> venceu()
                    ROSA -> empatou()
                }
            }

        }
    }

    private fun venceu() {
        vitorias++
        tvResultado.text = "Venceu"
        tvResultado.setTextColor(ContextCompat.getColor(this, R.color.vitoria))
        tvVitorias!!.text = vitorias.toString()
    }

    private fun perdeu() {
        vidas--
        validaVidas()
        tvResultado.text = "Perdeu"
        tvResultado.setTextColor(ContextCompat.getColor(this, R.color.derrota))
        tvDerrotas!!.text = vidas.toString()
    }

    private fun empatou() {
        empate++
        tvResultado.text = "Empatou"
        tvResultado.setTextColor(ContextCompat.getColor(this, R.color.empate))
        tvEmpates!!.text = empate.toString()
    }

    fun voltar(view: View) {
        val ir = btVoltar
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
        finish()
    }
}
