package hn.edu.ujcv.pdm_2021_ip2_proyecto2_grupo2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_enviar_factura.*
import kotlinx.android.synthetic.main.activity_factura.*
import kotlinx.android.synthetic.main.activity_registrar_empleado.*
import java.lang.StringBuilder

class RealizarFactura : AppCompatActivity() {
    var datos_cliente: HashMap<Int, String> = hashMapOf()
    var datos_menu: HashMap<Int, String> = hashMapOf()
    var datos_mesa: HashMap<Int, String> = hashMapOf()
    var datos_empleado: HashMap<Int, String> = hashMapOf()
    var datos_pedido: HashMap<Int, String> = hashMapOf()
    var datos_factura: HashMap<Int, String> = hashMapOf()
    var num = 0
    var des=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_factura)

        btn_GuardarFa.setOnClickListener {
            guardar()
        }
        btn_regresarFA.setOnClickListener {
            regresar()
        }
        btn_enviarFactura.setOnClickListener {
            go()
        }
        obtenerCliente()
        obtenerMenu()
        obtenerMesa()
        obtenerEmpleado()
        obtenerPedido()
        inicio()


        val spinner_TipoPago = findViewById<Spinner>(R.id.spinner_TipoPago)
        val lista_TipoPago  = resources.getStringArray(R.array.valoresPago)
        val adaptador2 = ArrayAdapter(this,android.R.layout.simple_spinner_item,lista_TipoPago )

        spinner_TipoPago .adapter =adaptador2
        spinner_TipoPago .onItemSelectedListener = object:
                AdapterView.OnItemSelectedListener { override fun onNothingSelected(parent: AdapterView<*>?) {
        }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
            {
            }
        }

    }

    private  fun guardar() {

        if (txt_CodigoPedido.text.toString().isEmpty()) {
            Toast.makeText(this, "Ingrese el Codigo del Pedido", Toast.LENGTH_SHORT).show()
        } else {
            if (spinner_TipoPago.selectedItem.toString().isEmpty()) {
                Toast.makeText(this, "Seleccione un opcion de Pago", Toast.LENGTH_SHORT).show()
            } else {
                if (txt_Clientefa.text.toString().isEmpty()) {
                    Toast.makeText(this, "Ingrese el nombre del cliente", Toast.LENGTH_SHORT).show()
                } else {
                    if (txt_EmpleadoFa.text.toString().isEmpty()) {
                        Toast.makeText(this, "Ingrese el codigo del empleado", Toast.LENGTH_SHORT).show()
                    } else {
                        if (txt_Total.text.toString().isEmpty()) {
                            Toast.makeText(this, "Ingrese el total a pagar ", Toast.LENGTH_SHORT).show()
                        } else {
                            val parametro = StringBuilder()
                            num += 1
                            parametro.append("\n DATOS FACTURA").append("|")
                            parametro.append(txt_CodigoPedido.text.toString().trim()).append("|")
                            parametro.append(spinner_TipoPago.selectedItem.toString().trim()).append("|")
                            parametro.append(txt_Clientefa.text.toString().trim()).append("|")
                            parametro.append(txt_EmpleadoFa.text.toString().trim()).append("|")
                            parametro.append(txt_COMBO.text.toString().trim()).append("|")
                            parametro.append(txt_Total.text.toString().trim()).append("|")
                            parametro.append(des.trim()).append("|")
                            datos_factura.put(num, parametro.toString())
                            println(datos_factura.toString())
                            Toast.makeText(this, "Factura Realizada", Toast.LENGTH_SHORT).show()
                        }
                    }
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
    private fun obtenerPedido(){
        val intent = intent
        datos_pedido= intent.getSerializableExtra("Pedido") as HashMap<Int,String>
        println(datos_pedido.toString())
    }

    fun inicio(){
        var a=""
        var b=""
        var c=0
        var d=""
        for(data in datos_pedido){
            val data1 = data.toString().split("|").toTypedArray()
            a=data1[1].toString()
            b=data1[2].toString()


        }
        txt_Clientefa.setText(a)
        txt_EmpleadoFa.setText(b)
        var com:String=""


        for(da in datos_pedido) {

            val data3 = da.toString().split("|").toTypedArray()
                c = c + data3[4].toInt()
                d = d + data3[3].toString()+","
                des=des+data3[5].toString()+","



                println("SI SE CUMPLIO")
            }







        txt_Total.setText(c.toString())
        txt_COMBO.setText(d)

    }

    fun go(){
        val intent = Intent(this, EnviarFactura::class.java)
        intent.putExtra("Cliente", datos_cliente)
        intent.putExtra("Menu", datos_menu)
        intent.putExtra("Mesa", datos_mesa)
        intent.putExtra("Empleado", datos_empleado)
        intent.putExtra("Pedido", datos_pedido)
        intent.putExtra("Factura", datos_factura)
        startActivity(intent)
    }




}