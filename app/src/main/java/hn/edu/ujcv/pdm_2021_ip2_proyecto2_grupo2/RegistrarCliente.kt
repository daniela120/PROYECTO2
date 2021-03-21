package hn.edu.ujcv.pdm_2021_ip2_proyecto2_grupo2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_registrar_cliente.*
import java.lang.StringBuilder

class RegistrarCliente : AppCompatActivity() {
    var datos_Cliente: HashMap<Int, String> = hashMapOf()
    var num = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_cliente)
        btn_regresar1.setOnClickListener {
            regresar() }
        btn_guardarCliente.setOnClickListener {
            guardar() }


    }


    private  fun guardar() {

        if (txt_IdCliente.text.toString().isEmpty()) {
            Toast.makeText(this, "Ingrese un numero de Identidad", Toast.LENGTH_SHORT).show()
        }else {
            if (txt_NomCliente.text.toString().isEmpty()) {
                Toast.makeText(this, "Ingrese un Nombre", Toast.LENGTH_SHORT).show()
            } else {
                if(txt_CorreoCliente.text.toString().isEmpty()){
                    Toast.makeText(this, "Ingrese un Correo", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Cliente Registrado", Toast.LENGTH_SHORT).show()
                    val parametro = StringBuilder()
                    num += 1
                    parametro.append("DATOS CLIENTES").append("|")
                    parametro.append(txt_IdCliente.text.toString().trim()).append("|")
                    parametro.append(txt_NomCliente.text.toString().trim()).append("|")
                    parametro.append(txt_CorreoCliente.text.toString().trim()).append("|")
                    datos_Cliente.put(num,parametro.toString())
                    println(datos_Cliente.toString())
                }
            }
        }
    }

    fun regresar() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}