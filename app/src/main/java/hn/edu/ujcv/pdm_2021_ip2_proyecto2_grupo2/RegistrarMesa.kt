package hn.edu.ujcv.pdm_2021_ip2_proyecto2_grupo2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_registrar_cliente.*
import kotlinx.android.synthetic.main.activity_registrar_mesa.*
import java.lang.StringBuilder

class RegistrarMesa : AppCompatActivity() {
    var datos_cliente: HashMap<Int, String> = hashMapOf()
    var datos_menu: HashMap<Int, String> = hashMapOf()
    var datos_mesa: HashMap<Int, String> = hashMapOf()
    var datos_empleado: HashMap<Int, String> = hashMapOf()
    var datos_pedido: HashMap<Int, String> = hashMapOf()
    var datos_factura: HashMap<Int, String> = hashMapOf()

    var num = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_mesa)
        btn_regresar3.setOnClickListener {
            regresar() }
        btn_GuardarMesa.setOnClickListener { guardar() }
        obtenerCliente()
        obtenerMenu()
        obtenerEmpleado()
        obtenerPedido()
        obtenerFactura()
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
                datos_mesa.put(num,parametro.toString())
                println(datos_mesa.toString())
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

    private fun obtenerEmpleado(){
        val intent = intent
        datos_empleado= intent.getSerializableExtra("Empleado") as HashMap<Int,String>
        println(datos_empleado.toString())
    }
    private fun obtenerPedido(){
        val intent = intent
        datos_pedido= intent.getSerializableExtra("Pedido") as HashMap<Int,String>
        println(datos_pedido.toString())
    }

    private fun obtenerFactura(){
        val intent = intent
        datos_factura= intent.getSerializableExtra("Factura") as HashMap<Int,String>
        println(datos_factura.toString())
    }



}