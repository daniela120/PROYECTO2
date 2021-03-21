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
            Snackbar.make(view, "Item agregado a la lista", Snackbar.LENGTH_LONG)
                    .setAction("Deshacer", deshacerOnclickListener).show()
        }
    }


    var deshacerOnclickListener: View.OnClickListener = View.OnClickListener { view ->
        listItem.removeAt(listItem.size -1)
        adapter?.notifyDataSetChanged()
        Snackbar.make(view, "Item Eliminado", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
    }

    private fun addListItem() {
        val dateFormat: SimpleDateFormat =
                SimpleDateFormat( "HH:mm:ss dd/MM/yyyy", Locale.US)
        listItem.add(dateFormat.format(Date()))
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
            if (txt_NombreMenu.text.toString().isEmpty()) {
                Toast.makeText(this, "Ingrese un Nombre de menu", Toast.LENGTH_SHORT).show()
            } else {
                if (txt_DescripcionMenu.text.toString().isEmpty()) {
                    Toast.makeText(this, "Ingrese una descripcion", Toast.LENGTH_SHORT).show()
                } else {
                    if (txt_PrecioMenu.text.toString().isEmpty()) {
                        Toast.makeText(this, "Ingrese el precio del menu", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Menu Registrado", Toast.LENGTH_SHORT).show()
                        val parametro = StringBuilder()
                        num += 1
                        parametro.append("DATOS MENU").append("|")
                        parametro.append(txt_CodigoMenu.text.toString().trim()).append("|")
                        parametro.append(txt_NombreMenu.text.toString().trim()).append("|")
                        parametro.append(txt_DescripcionMenu.text.toString().trim()).append("|")
                        parametro.append(txt_PrecioMenu.text.toString().trim()).append("|")
                        datos_Menu.put(num, parametro.toString())
                        println(datos_Menu.toString())
                    }
                }
            }
        }
    }

    fun regresar() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
