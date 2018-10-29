package adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.corem.myapplication.R
import kotlinx.android.synthetic.main.score_card.view.*
import model.Jogador


class ScoreAdapter (

        private val jogadores: List<Jogador>,
        val context: Context,
        val listener: (Jogador) -> Unit): RecyclerView.Adapter<ScoreAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ScoreAdapter.ViewHolder, position: Int) {
        val jogadorPosition = jogadores[position]
        holder?.let {
            it.bindView(jogadorPosition, listener)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(
                R.layout.score_card,parent,false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return jogadores.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bindView (jogador: Jogador,
                      listener: (Jogador) -> Unit)= with(itemView){

            val tvName = tvName
            val tvScorer = tvScorer
            val tvPontos = tvPontos

            //user image

            ivPlayer.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.pokeuser))

            tvName.text = jogador.nome
            tvScorer.text = jogador.pontos.toString()
            tvPontos.text = "Hi-Score"

            setOnClickListener{listener(jogador)}
        }
    }
}
