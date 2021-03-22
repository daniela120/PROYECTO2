package hn.edu.ujcv.pdm_2021_ip2_proyecto2_grupo2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_registrar_empleado.*
import java.lang.StringBuilder

class RegistrarEmpleado : AppCompatActivity() {
    var datos_cliente: HashMap<Int, String> = hashMapOf()
    var datos_menu: HashMap<Int, String> = hashMapOf()
    var datos_mesa: HashMap<Int, String> = hashMapOf()
    var datos_empleado: HashMap<Int, String> = hashMapOf()
    var datos_pedido: HashMap<Int, String> = hashMapOf()
    var datos_factura: HashMap<Int, String> = hashMapOf()
    var num = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_empleado)
        btn_regresar4.setOnClickListener { regresar() }
        btn_GuardarEmpleado.setOnClickListener { guardar() }

        val spinner_Puestos = findViewById<Spinner>(R.id.spinner_PuestoEmpleado)
        val lista_Puestos = resources.getStringArray(R.array.valoresPuesto)
        val adaptador = ArrayAdapter(this,android.R.layout.simple_spinner_item,lista_Puestos)

        spinner_Puestos.adapter =adaptador
        spinner_Puestos.onItemSelectedListener = object:
                AdapterView.OnItemSelectedListener { override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
            {
            }
        }
        obtenerCliente()
        obtenerMenu()
        obtenerMesa()
        obtenerPedido()
        obtenerFactura()
    }
    private  fun guardar() {

        if (txt_CodigoEmpleado.text.toString().isEmpty()) {
            Toast.makeText(this, "Ingrese el Codigo del Empleado", Toast.LENGTH_SHORT).show()
        } else {
            if (txt_CodigoEmpleado.text.toString().isEmpty()) {
                Toast.makeText(this, "Ingrese el Nombre del Empleado", Toast.LENGTH_SHORT).show()
            } else {
                if (spinner_PuestoEmpleado.selectedItem.toString().isEmpty()) {
                    Toast.makeText(this, "Ingrese el Puesto del Empleado", Toast.LENGTH_SHORT).show()
                } else {
                    val parametro = StringBuilder()
                    num += 1
                    parametro.append("DATOS EMPLEADO").append("/n")
                    parametro.append(txt_CodigoEmpleado.text.toString().trim()).append("/n")
                    parametro.append(txt_NombreEmpleado.text.toString().trim()).append("/n")
                    parametro.append(spinner_PuestoEmpleado.selectedItem.toString().trim()).append("/n")
                    datos_empleado.put(num, parametro.toString())
                    println(datos_empleado.toString())
                    Toast.makeText(this, "Empleado  Registrado", Toast.LENGTH_SHORT).show()
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