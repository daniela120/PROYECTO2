package hn.edu.ujcv.pdm_2021_ip2_proyecto2_grupo2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_registrar_cliente.*
import kotlinx.android.synthetic.main.activity_registrar_mesa.*
import java.lang.StringBuilder

class RegistrarMesa : AppCompatActivity() {
    var datos_Mesa: HashMap<Int, String> = hashMapOf()
    var num = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_mesa)
        btn_regresar3.setOnClickListener { regresar() }
        btn_GuardarMesa.setOnClickListener { guardar() }
    }

    private  fun guardar() {

        if (txt_CodigoMesa.text.toString().isEmpty()) {
            Toast.makeText(this, "Ingrese el Codigo de la Mesa", Toast.LENGTH_SHORT).show()
        }else {
            if (txt_DescripcionMesa.text.toString().isEmpty()) {
                Toast.makeText(this, "Ingrese la Descripcion de la Mesa", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Mesa Registrada", Toast.LENGTH_SHORT).show()
                val parametro = StringBuilder()
                num += 1
                parametro.append("DATOS MESA").append("|")
                parametro.append(txt_CodigoMesa.text.toString().trim()).append("|")
                parametro.append(txt_DescripcionMesa.text.toString().trim()).append("|")
                datos_Mesa.put(num,parametro.toString())
                println(datos_Mesa.toString())
            }
        }
    }

    fun regresar() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}