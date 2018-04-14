package br.com.fiap.dado

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*

class GameActivity : AppCompatActivity() {

    var vitorias = 0
    var derrotas = 0
    var empates = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        btJogar.setOnClickListener {
            jogar()
        }
    }

    fun jogar() {
        val geradoDeNumero = Random()
        val dadoJogador = geradoDeNumero.nextInt(6) + 1
        val dadoPC = geradoDeNumero.nextInt(6) + 1

        configuraImagem(dadoJogador, ivDadoJogador)
        configuraImagem(dadoPC, ivDadoPC)

        analisaResultado(dadoJogador, dadoPC)
    }

    fun analisaResultado(numeroJogador: Int, numeroPC: Int) {
        if (numeroJogador > numeroPC) {
            vitorias++
            tvVitorias.text = vitorias.toString()
        } else if (numeroJogador < numeroPC) {
            derrotas++
            tvDerrotas.text = derrotas.toString()
        } else {
            empates++
            tvEmpates.text = empates.toString()
        }
    }

    fun configuraImagem(numero: Int, imageView: ImageView) {
        when (numero) {
            1 -> imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dice_1))
            2 -> imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dice_2))
            3 -> imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dice_3))
            4 -> imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dice_4))
            5 -> imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dice_5))
            6 -> imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dice_6))
        }
    }
}
