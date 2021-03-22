package hn.edu.ujcv.pdm_2021_ip2_proyecto2_grupo2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_enviar_factura.*


class EnviarFactura : AppCompatActivity() {
    var factura:HashMap<Int,String> = hashMapOf()
    var datos_Cliente: HashMap<Int, String> = hashMapOf()
    var datos_mesa: HashMap<Int, String> = hashMapOf()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enviar_factura)
        btn_regresarEnviarFA.setOnClickListener {
            regresaralmenu()
        }
        btn_EnviarCorreo.setOnClickListener {
            enviar()
        }
        obtenerCliente()
        obtenerMesa()


    }


    private fun regresaralmenu() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("Cliente", datos_Cliente)
        intent.putExtra("status","true")
        startActivity(intent)
    }


    private fun enviar(){
        var to = arrayOf<String>(txt_CorreoDestino.text.toString(), "helen.orellana1@ujcv.edu.hn","miguel.torres@ujcv.edu.hn","Daniela.herrera@ujcv.edu.hn","edwin.espino@ujcv.edu.hn")
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_EMAIL,to)
        intent.putExtra(Intent.EXTRA_SUBJECT, txt_Asunto.text.toString())
        intent.putExtra(Intent.EXTRA_TEXT, factura.toString())
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Email"))


    }

    private fun obtenerCliente(){
        val intent = intent
        datos_Cliente= intent.getSerializableExtra("Cliente") as HashMap<Int,String>
        println(datos_Cliente.toString())
    }

    private fun obtenerMesa(){
        val intent = intent
        datos_mesa= intent.getSerializableExtra("Mesa") as HashMap<Int,String>
        println(datos_mesa.toString())
    }

}