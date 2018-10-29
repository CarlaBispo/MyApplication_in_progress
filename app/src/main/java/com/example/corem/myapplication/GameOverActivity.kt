package com.example.corem.myapplication

import Api.JokenpoService
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game_over.*
import model.Jogador
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GameOverActivity : AppCompatActivity() {

    private val delayInicio = 1000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)

        //recupera variavel "vitorias" enviada p tela game
        val vitorias = intent.extras.getInt("Hi-Score")

        //linkando api
        val retrofit = Retrofit.Builder()
                .baseUrl("https://gamestjd.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        btPlayAgain.setOnClickListener {
            val service = retrofit.create(JokenpoService::class.java!!)
            //usar post e passar parametros p o objeto enviar a api nome do user + pontos obtidos
            service.enviarPontuacao(pontuacao = Jogador(etNome.text.toString(), vitorias))
                    .enqueue(object : Callback<Void> {
                        override fun onFailure(call: Call<Void>, t: Throwable) {
                            Toast.makeText(this@GameOverActivity, "Falha no envio de dados",
                                    Toast.LENGTH_SHORT).show()
                        }

                        override fun onResponse(call: Call<Void>, response: Response<Void>) {
                            Toast.makeText(this@GameOverActivity, "Sucesso!",
                                    Toast.LENGTH_SHORT).show()
                        }
                    })
            Handler().postDelayed({
                val Play = Intent(this, PlayActivity::class.java)
                startActivity(Play)
                finish()
            }, delayInicio)
        }

        btQuit2.setOnClickListener {
            val Menu = Intent(this, MenuActivity::class.java)
            startActivity(Menu)
            finish()
        }

        // botoes
        //abaixo interface simples de botao p mudanca de tela

        /*fun playagain (view: View) {
        val playagain = btPlayAgain
        val intent = Intent(this, PlayActivity::class.java)
        startActivity(intent)
        //finish()
    }

        fun quit2(view: View) {
            val quit = btQuit2
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            //finish()
            }
            */

        }

    }
