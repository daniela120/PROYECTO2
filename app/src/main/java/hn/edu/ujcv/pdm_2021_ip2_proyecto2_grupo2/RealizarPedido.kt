package hn.edu.ujcv.pdm_2021_ip2_proyecto2_grupo2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_realizar_pedido.*

class RealizarPedido : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realizar_pedido)
      btn_regresarPedido.setOnClickListener { regresar() }

    }

    fun regresar() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}