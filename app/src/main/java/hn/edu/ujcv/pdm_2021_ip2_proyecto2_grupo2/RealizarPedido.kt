package hn.edu.ujcv.pdm_2021_ip2_proyecto2_grupo2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isEmpty
import kotlinx.android.synthetic.main.activity_realizar_pedido.*
import kotlinx.android.synthetic.main.activity_registrar_cliente.*
import kotlinx.android.synthetic.main.activity_registrar_empleado.*
import kotlinx.android.synthetic.main.activity_registrar_menu.*
import java.lang.StringBuilder

class RealizarPedido : AppCompatActivity() {
    var datos_cliente: HashMap<Int, String> = hashMapOf()
    var datos_menu: HashMap<Int, String> = hashMapOf()
    var datos_mesa: HashMap<Int, String> = hashMapOf()
    var datos_empleado: HashMap<Int, String> = hashMapOf()
    var datos_pedido: HashMap<Int, String> = hashMapOf()
    var datos_factura: HashMap<Int, String> = hashMapOf()
    var num = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realizar_pedido)
      btn_regresarPedido.setOnClickListener { regresar() }
      btn_GuardarPedido.setOnClickListener { guardar() }
        obtenerCliente()
        obtenerMenu()
        obtenerMesa()
        obtenerEmpleado()
        obtenerFactura()
        iniciar()

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


    fun guardar() {
        var a = 0
        var b = ""
        if (spinner_TipoPago.isEmpty()) {
            Toast.makeText(this, "No hay menus para seleccionar", Toast.LENGTH_SHORT).show()
        } else {
            if (txt_ClientePe.text.toString().isEmpty()) {
                Toast.makeText(this, "Debe ingresar un nombre", Toast.LENGTH_SHORT).show()

            } else {
                val parametro = StringBuilder()
                num += 1
                parametro.append("DATOS DEL PEDIDO").append("|")
                parametro.append(txt_ClientePe.text.toString().trim()).append("|")
                parametro.append(txt_EmpleadoPe.text.toString().trim()).append("|")
                parametro.append(spinner_TipoPago.selectedItem.toString().trim()).append("|")

                for (d in datos_menu) {
                    var data3 = d.toString().split("|").toTypedArray()
                    var f = data3[2]
                    if (spinner_TipoPago.selectedItem.toString() == f) {
                        a = a + data3[4].toInt()
                        parametro.append(a.toString().trim()).append("|")
                    }
                }

                for (l in datos_menu) {
                    var data4 = l.toString().split("|").toTypedArray()
                    var y = data4[2]
                    if (spinner_TipoPago.selectedItem.toString() == y) {
                        val x = data4[3]
                        parametro.append(x.trim()).append("|")
                    }


                }



                datos_pedido.put(num, parametro.toString())
                println(datos_pedido.toString())
                Toast.makeText(this, "Su pedido se Realizo de manera exitosa", Toast.LENGTH_SHORT).show()
            }
        }
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

    fun iniciar(){
        val spinner_pedido = findViewById<Spinner>(R.id.spinner_TipoPago)
        var A:ArrayList<String> = ArrayList()
        var empleados:String=""
        var a:String=""
        var b:String=""
        for(i in datos_menu){
            val data = i.toString().split("|").toTypedArray()
            empleados=data[2].toString()
            A.add(empleados)
            Toast.makeText(this, "Pedido realizado", Toast.LENGTH_SHORT).show()
        }
        val adaptador = ArrayAdapter(this,android.R.layout.simple_spinner_item, A)
        spinner_pedido.adapter =adaptador
        spinner_pedido.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long){
                    txvCombo.text=A[position].toString()

            }

        }


        for(data in datos_cliente){
            val data1 = data.toString().split("|").toTypedArray()
            a=data1[2].toString()


        }
        txt_ClientePe.setText(a)

        for(d in datos_empleado){
            val data1 = d.toString().split("|").toTypedArray()
            b=data1[2].toString()


        }
        txt_EmpleadoPe.setText(b)

    }



}