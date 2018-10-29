package com.example.corem.myapplication

import Api.JokenpoService
import adapter.ScoreAdapter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_score.*
import model.Jogador
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val retrofit = Retrofit.Builder()
                .baseUrl("https://gamestjd.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(JokenpoService::class.java!!)
        //get on api
        service.buscarRanking()
                .enqueue(object : Callback<List<Jogador>>{

                    override fun onFailure(call: Call<List<Jogador>>, t: Throwable) {
                        Toast.makeText(this@ScoreActivity,
                                "Falha ae!",
                                Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(call: Call<List<Jogador>>, response: Response<List<Jogador>>) {
                        response?.body()?.let {
                            val jogadores: List<Jogador> = it
                            configureList(jogadores)
                        }
                    }

                })
    }

    fun configureList(jogadores:List<Jogador>){
        val recyclerview = rvScoring
        recyclerview.adapter = ScoreAdapter(jogadores, this,{
            Toast.makeText(this, "O player: " + it.nome + "tem total de" + it.pontos + "pontos.", Toast.LENGTH_LONG).show()
        })
        recyclerview.layoutManager = LinearLayoutManager(this)
    }

}
