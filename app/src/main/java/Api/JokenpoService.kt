package Api

import model.Jogador
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface JokenpoService {

    @POST("/jokenpokemon/pontuacao")
    fun enviarPontuacao(@Body pontuacao: Jogador): Call<Void>

    @GET("/jokenpokemon/pontuacao")
    fun buscarRanking(): Call<List<Jogador>>
}