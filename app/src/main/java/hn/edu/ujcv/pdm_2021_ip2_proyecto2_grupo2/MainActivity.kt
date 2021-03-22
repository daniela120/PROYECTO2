package hn.edu.ujcv.pdm_2021_ip2_proyecto2_grupo2

import android.graphics.Color
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.core.view.size
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerAdapter = RecyclerAdapter()

    /*DEFINICION DE LAS LISTAS*/
    var datos_cliente: HashMap<Int, String> = hashMapOf()
    var datos_menu: HashMap<Int, String> = hashMapOf()
    var datos_mesa: HashMap<Int, String> = hashMapOf()
    var datos_empleado: HashMap<Int, String> = hashMapOf()
    var datos_pedido: HashMap<Int, String> = hashMapOf()
    var datos_factura: HashMap<Int, String> = hashMapOf()

    /*DECLARACION DE LOS ESTADOS*/
    var estado_cliente ="false"
    var estado_menu ="false"
    var estado_mesa ="false"
    var estado_empleado ="false"
    var estado_pedido ="false"
    var estado_factura ="false"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        collapsing_toolbar.title = "La Cocina de Mexico"
        collapsing_toolbar.setContentScrimColor(Color.BLUE)

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter=adapter

        estado_cliente()
        estado_menu()
        estado_mesa()
        estado_empleado()
        estado_pedido()
        estado_factura()

        if(estado_cliente=="true"){
            obtenerCliente()
            adapter.setCliente(datos_cliente)

        }

        if(estado_menu=="true"){
            obtenerMenu()
            adapter.setMenu(datos_menu)

        }

        if(estado_mesa=="true"){
            obtenerMesa()
            adapter.setMesa(datos_mesa)

        }

        if(estado_empleado=="true"){
            obtenerEmpleado()
            adapter.setEmpleado(datos_empleado)

        }

        if(estado_pedido=="true"){
            obtenerPedido()
            adapter.setPedido(datos_pedido)

        }

        if(estado_factura=="true"){
            obtenerFactura()
            adapter.setFactura(datos_factura)

        }




    }

    /*OBTENCION DE LOS ESTADOS DE LAS LISTAS*/
    private fun estado_cliente(){
        val bundle = intent.extras
        val get = bundle?.get("status-c")
        this.estado_cliente = getString(R.string.estados, get)

    }

    private fun estado_menu(){
        val bundle = intent.extras
        val get = bundle?.get("status-m")
        this.estado_menu = getString(R.string.estados, get)

    }

    private fun estado_mesa(){
        val bundle = intent.extras
        val get = bundle?.get("status-me")
        this.estado_mesa = getString(R.string.estados, get)

    }

    private fun estado_empleado(){
        val bundle = intent.extras
        val get = bundle?.get("status-e")
        this.estado_empleado = getString(R.string.estados, get)

    }

    private fun estado_pedido(){
        val bundle = intent.extras
        val get = bundle?.get("status-p")
        this.estado_pedido = getString(R.string.estados, get)

    }

    private fun estado_factura(){
        val bundle = intent.extras
        val get = bundle?.get("status-f")
        this.estado_factura = getString(R.string.estados, get)

    }


    /*OBTENCION DE LAS LISTAS*/

    private fun obtenerCliente(){
        val intent = intent
        datos_cliente= intent.getSerializableExtra("Cliente") as HashMap<Int,String>
        println("El cliente es: "+datos_cliente.toString())
    }
    private fun obtenerMenu(){
        val intent = intent
        datos_menu= intent.getSerializableExtra("Menu") as HashMap<Int,String>
        println("El menu es: " +datos_menu.toString())
    }
    private fun obtenerMesa(){
        val intent = intent
        datos_mesa= intent.getSerializableExtra("Mesa") as HashMap<Int,String>
        println("La mesa es: "+datos_mesa.toString())
    }
    private fun obtenerEmpleado(){
        val intent = intent
        datos_empleado= intent.getSerializableExtra("Empleado") as HashMap<Int,String>
        println("El empleado es: "+datos_empleado.toString())
    }
    private fun obtenerPedido(){
        val intent = intent
        datos_pedido= intent.getSerializableExtra("Pedido") as HashMap<Int,String>
        println("El pedido es: "+datos_pedido.toString())
    }

    private fun obtenerFactura(){
        val intent = intent
        datos_factura= intent.getSerializableExtra("Factura") as HashMap<Int,String>
        println("La factura es: "+datos_factura.toString())
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}