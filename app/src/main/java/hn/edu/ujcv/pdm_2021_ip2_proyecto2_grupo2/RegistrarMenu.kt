package hn.edu.ujcv.pdm_2021_ip2_proyecto2_grupo2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_registrar_cliente.*
import kotlinx.android.synthetic.main.activity_registrar_menu.*
import kotlinx.android.synthetic.main.fragment_first.*
import java.lang.StringBuilder
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap

class RegistrarMenu : AppCompatActivity() {

    var datos_cliente: HashMap<Int, String> = hashMapOf()
    var datos_menu: HashMap<Int, String> = hashMapOf()
    var datos_mesa: HashMap<Int, String> = hashMapOf()
    var datos_empleado: HashMap<Int, String> = hashMapOf()
    var datos_pedido: HashMap<Int, String> = hashMapOf()
    var datos_factura: HashMap<Int, String> = hashMapOf()
    var num = 0
    var listItem = ArrayList<String>()
    var adapter: ArrayAdapter<String>? = null
    var stado:Boolean=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_menu)


        btn_regresarMenu.setOnClickListener {
            regresar()
        }
        btn_GuardarMenu.setOnClickListener { view ->
            guardar()
            if(stado==true){
                addListItem()
                Snackbar.make(view, "Menu agregado a la lista", Snackbar.LENGTH_LONG)
                    .setAction("Deshacer", deshacerOnclickListener).show()
            }

        }


     /* val spinner_Menus = findViewById<Spinner>(R.id.spinner_NombreMenu)
        val lista_Menus = resources.getStringArray(R.array.valoresMenu)
        val adaptador = ArrayAdapter(this,android.R.layout.simple_spinner_item,lista_Menus)

        spinner_Menus.adapter =adaptador
        spinner_Menus.onItemSelectedListener = object:
                AdapterView.OnItemSelectedListener { override fun onNothingSelected(parent: AdapterView<*>?) {
        }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
            {
                if (position==0){
                    txvDescripcion.text="El Combo Incluye"+"\n 4 tacos, 2 refresco "+ "\n Valor = L. 300"
                }else
                    if (position==1) {
                        txvDescripcion.text = "El Combo Incluye"+"\n 4 nachos, 4 refrescos" +
                                "\n Valor = L. 300"


                    }else
                        if (position==2) {
                            txvDescripcion.text = "El Combo Incluye"+"\n 2 burritos, 1 refresco" +
                                    "\nValor = L. 250"
                        }else
                            if (position==3) {
                                txvDescripcion.text = "El Combo Incluye"+"\n 2 tacos, 1 refresco." +
                                        "\nValor = L. 180"
                            }else
                                if (position==4) {
                                    txvDescripcion.text = "El Combo Incluye"+"\n 4 chiles rellenos, 1 refresco." +
                                            "\nValor = L. 330"
                                }else
                                    if (position==5) {
                                        txvDescripcion.text = "El Combo Incluye"+"\n 4 chilaquiles, 4 refresco" +
                                                "\nValor = L. 280"
                                    }else
                                        if (position==6) {
                                            txvDescripcion.text = "El Combo Incluye"+"\n 1 Torta, 1 refresco" +
                                                    "\nValor = L. 340"
                                        }else
                                            if (position==7) {
                                                txvDescripcion.text = "El Combo Incluye"+"\n 1 Mexican Burger, 1 refresco" +
                                                        "\nValor = L. 199"
                                            }
            }
                                        }







       val spinner_DescripcionMenus = findViewById<Spinner>(R.id.spinner_DescripcionMenu)
        val lista_DescripcionMenus  = resources.getStringArray(R.array.valoresDescripcionMenu)
        val adaptador1 = ArrayAdapter(this,android.R.layout.simple_spinner_item,lista_DescripcionMenus )

        spinner_DescripcionMenus .adapter =adaptador1
        spinner_DescripcionMenus .onItemSelectedListener = object:
                AdapterView.OnItemSelectedListener { override fun onNothingSelected(parent: AdapterView<*>?) {
        }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
            {
            }
        }
        val spinner_PrecioMenus = findViewById<Spinner>(R.id.spinner_PrecioMenu)
        val lista_PrecioMenus = resources.getStringArray(R.array.valoresPrecioMenu)
        val adaptador2 = ArrayAdapter(this,android.R.layout.simple_spinner_item,lista_PrecioMenus)

        spinner_PrecioMenus.adapter =adaptador2
        spinner_PrecioMenus.onItemSelectedListener = object:
                AdapterView.OnItemSelectedListener { override fun onNothingSelected(parent: AdapterView<*>?) {
        }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
            {
            }
        }*/
        obtenerCliente()
        obtenerMesa()
        obtenerEmpleado()
        obtenerPedido()
        obtenerFactura()
    }


    var deshacerOnclickListener: View.OnClickListener = View.OnClickListener { view ->
        listItem.removeAt(listItem.size -1)
        adapter?.notifyDataSetChanged()
        Snackbar.make(view, "Menu Eliminado", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
    }

    private fun addListItem() {
        listItem.add("MENU CREADO"+"\n"+txt_CodigoMenu.text.toString()+"\n"+txt_Nombre.text.toString()+"\n"+txt_Detalles.text.toString()+"\n"+txt_Precio.text.toString())
        adapter?.notifyDataSetChanged()
    }

    override fun onStart() {
        super.onStart()
        adapter = ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                listItem)
        lstView.adapter = adapter
    }

    private fun guardar() {

        if (txt_CodigoMenu.text.isEmpty()) {
            Toast.makeText(this, "Ingrese el codigo del menu", Toast.LENGTH_SHORT).show()
        } else {
            val parametro = StringBuilder()
            num += 1
            parametro.append("DATOS MENU").append("|")
            parametro.append(txt_CodigoMenu.text.toString().trim()).append("\n")
            parametro.append(txt_Nombre.text.toString().trim()).append("\n")
            parametro.append(txt_Detalles.text.toString().trim()).append("\n")
            parametro.append(txt_Precio.text.toString().trim()).append("\n")
            datos_menu.put(num, parametro.toString())
            println(datos_menu.toString())
            stado=true


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

    private fun obtenerFactura(){
        val intent = intent
        datos_factura= intent.getSerializableExtra("Factura") as HashMap<Int,String>
        println(datos_factura.toString())
    }





}
