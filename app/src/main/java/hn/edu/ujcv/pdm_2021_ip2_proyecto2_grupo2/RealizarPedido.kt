package hn.edu.ujcv.pdm_2021_ip2_proyecto2_grupo2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_realizar_pedido.*

class RealizarPedido : AppCompatActivity() {
    var datos_cliente: HashMap<Int, String> = hashMapOf()
    var datos_menu: HashMap<Int, String> = hashMapOf()
    var datos_mesa: HashMap<Int, String> = hashMapOf()
    var datos_empleado: HashMap<Int, String> = hashMapOf()
    var datos_pedido: HashMap<Int, String> = hashMapOf()
    var datos_factura: HashMap<Int, String> = hashMapOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realizar_pedido)
      btn_regresarPedido.setOnClickListener { regresar() }
        obtenerCliente()
        obtenerMenu()
        obtenerMesa()
        obtenerEmpleado()
        obtenerFactura()

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

    /*OBTENCION DE LAS LISTAS*/

    private fun obtenerCliente(){
        val intent = intent
        datos_cliente= intent.getSerializableExtra("Cliente") as HashMap<Int,String>
        println(datos_cliente.toString())
    }
    private fun obtenerMenu(){
        val intent = intent
        datos_menu= intent.getSerializableExtra("Menu") as HashMap<Int,String>
        println(datos_menu.toString())
    }
    private fun obtenerMesa(){
        val intent = intent
        datos_mesa= intent.getSerializableExtra("Mesa") as HashMap<Int,String>
        println(datos_mesa.toString())
    }
    private fun obtenerEmpleado(){
        val intent = intent
        datos_empleado= intent.getSerializableExtra("Empleado") as HashMap<Int,String>
        println(datos_empleado.toString())
    }

    private fun obtenerFactura(){
        val intent = intent
        datos_factura= intent.getSerializableExtra("Factura") as HashMap<Int,String>
        println(datos_factura.toString())
    }

}