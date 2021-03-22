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

    var datos_Menu: HashMap<Int, String> = hashMapOf()
    var num = 0
    var listItem = ArrayList<String>()
    var adapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_menu)

        btn_GuardarMenu.setOnClickListener {
            guardar()
        }
        btn_regresarMenu.setOnClickListener {
            regresar()
        }
        btn_GuardarMenu.setOnClickListener { view ->
            addListItem()
            Snackbar.make(view, "Menu agregado a la lista", Snackbar.LENGTH_LONG)
                    .setAction("Deshacer", deshacerOnclickListener).show()
        }
        btn_VerMenus.setOnClickListener { mostrar() }

        val spinner_Menus = findViewById<Spinner>(R.id.spinner_NombreMenu)
        val lista_Menus = resources.getStringArray(R.array.valoresMenu)
        val adaptador = ArrayAdapter(this,android.R.layout.simple_spinner_item,lista_Menus)

        spinner_Menus.adapter =adaptador
        spinner_Menus.onItemSelectedListener = object:
                AdapterView.OnItemSelectedListener { override fun onNothingSelected(parent: AdapterView<*>?) {
        }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
            {
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
        }
    }


    var deshacerOnclickListener: View.OnClickListener = View.OnClickListener { view ->
        listItem.removeAt(listItem.size -1)
        adapter?.notifyDataSetChanged()
        Snackbar.make(view, "Menu Eliminado", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
    }

    private fun addListItem() {
        listItem.add(spinner_NombreMenu.selectedItem.toString()+" - "+spinner_PrecioMenu.selectedItem.toString())
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

        if (txt_CodigoMenu.text.toString().isEmpty()) {
            Toast.makeText(this, "Ingrese el codigo del menu", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Menu Registrado", Toast.LENGTH_SHORT).show()
                        val parametro = StringBuilder()
                        num += 1
                        parametro.append("DATOS MENU").append("|")
                        parametro.append(txt_CodigoMenu.text.toString().trim()).append("|")
                        parametro.append(spinner_DescripcionMenu.toString().trim()).append("|")
                        parametro.append(spinner_NombreMenu.selectedItem.toString().trim()).append("|")
                        parametro.append(spinner_PrecioMenu.selectedItem.toString().trim()).append("|")
                        datos_Menu.put(num, parametro.toString())
                        println(datos_Menu.toString())
                    }
                }




    fun regresar() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    fun mostrar() {
        val intent = Intent(this, RecyclerAdapter::class.java)
        startActivity(intent)
    }


}
