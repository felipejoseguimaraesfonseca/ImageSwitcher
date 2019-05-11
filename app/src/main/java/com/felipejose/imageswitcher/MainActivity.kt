package com.felipejose.imageswitcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageSwitcher
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    lateinit var trocaImagem: ImageSwitcher
    lateinit var voltar: Button
    lateinit var proximo: Button
    lateinit var imagem: IntArray
    var posicao: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trocaImagem = findViewById(R.id.trocaImagem)
        voltar = findViewById(R.id.voltar)
        proximo = findViewById(R.id.proximo)

        imagem = intArrayOf(R.drawable.kotlin,R.drawable.java,R.drawable.javascript,R.drawable.python,R.drawable.cmaismais)

        trocaImagem.setFactory {
            val imageView = ImageView(applicationContext)
            imageView.scaleType = ImageView.ScaleType.FIT_CENTER
            imageView
        }
        voltar.setOnClickListener {
            if (posicao > 0){
                posicao -= 1
                trocaImagem.setImageResource(imagem[posicao])
            }
        }
        proximo.setOnClickListener {
            if (posicao < imagem.size-1){
                posicao += 1
                trocaImagem.setImageResource(imagem[posicao])
            }
        }
    }
}
