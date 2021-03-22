package hn.edu.ujcv.pdm_2021_ip2_proyecto2_grupo2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_registrar_cliente.*
import kotlinx.android.synthetic.main.activity_registrar_menu.*
import java.lang.StringBuilder
import java.util.ArrayList
import java.util.*

class RegistrarCliente : AppCompatActivity() {
    var datos_cliente: HashMap<Int, String> = hashMapOf()
    var datos_menu: HashMap<Int, String> = hashMapOf()
    var datos_mesa: HashMap<Int, String> = hashMapOf()
    var datos_empleado: HashMap<Int, String> = hashMapOf()
    var datos_pedido: HashMap<Int, String> = hashMapOf()
    var datos_factura: HashMap<Int, String> = hashMapOf()
    var listItem = ArrayList<String>()
    var adapter: ArrayAdapter<String>? = null
    var stado:Boolean=false
    var num = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_cliente)
        btn_regresar1.setOnClickListener {
            regresar() }
        btn_guardarCliente.setOnClickListener { view ->
            guardar()
          }
        obtenerMenu()
        obtenerMesa()
        obtenerEmpleado()
        obtenerPedido()
        obtenerFactura()



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

                    val parametro = StringBuilder()
                    num += 1
                    parametro.append("DATOS CLIENTES").append("|")
                    parametro.append(txt_IdCliente.text.toString().trim()).append("|")
                    parametro.append(txt_NomCliente.text.toString().trim()).append("|")
                    parametro.append(txt_CorreoCliente.text.toString().trim()).append("|")
                    datos_cliente.put(num,parametro.toString())
                    println(datos_cliente.toString())
                    Toast.makeText(this, "Cliente Registrado", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    fun regresar() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("Cliente", datos_cliente)
        intent.putExtra("status-c","true")
        intent.putExtra("Menu", datos_menu)
        intent.putExtra("status-m","true")
        intent.putExtra("Mesa", datos_mesa)
        intent.putExtra("status-me","true")
        intent.putExtra("Empleado", datos_empleado)
        intent.putExtra("status-e","true")
        intent.putExtra("Pedido", datos_pedido)
        intent.putExtra("status-p","true")
        intent.putExtra("Factura", datos_factura)
        intent.putExtra("status-f","true")
        startActivity(intent)
    }

    /*OBTENER LISTAS*/

    private fun obtenerMenu(){
        val intent = intent
        datos_menu= intent.getSerializableExtra("Menu") as HashMap<Int,String>
        println("Recibi menu: "+datos_menu.toString())
    }
    private fun obtenerMesa(){
        val intent = intent
        datos_mesa= intent.getSerializableExtra("Mesa") as HashMap<Int,String>
        println("Recibi mesa: "+datos_mesa.toString())
    }
    private fun obtenerEmpleado(){
        val intent = intent
        datos_empleado= intent.getSerializableExtra("Empleado") as HashMap<Int,String>
        println("Recibi empleado: "+datos_empleado.toString())
    }
    private fun obtenerPedido(){
        val intent = intent
        datos_pedido= intent.getSerializableExtra("Pedido") as HashMap<Int,String>
        println("Recibi pedido: "+datos_pedido.toString())
    }

    private fun obtenerFactura(){
        val intent = intent
        datos_factura= intent.getSerializableExtra("Factura") as HashMap<Int,String>
        println("Recibi factura: "+datos_factura.toString())
    }

}