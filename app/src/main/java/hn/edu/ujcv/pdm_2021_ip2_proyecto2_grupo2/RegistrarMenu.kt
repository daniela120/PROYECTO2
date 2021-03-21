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
        mostrar()
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
                        Toast.makeText(this, "Menu Registrado", Toast.LENGTH_SHORT).show()
                        val parametro = StringBuilder()
                        num += 1
                        parametro.append("DATOS MENU").append("|")
                        parametro.append(txt_CodigoMenu.text.toString().trim()).append("|")
                        parametro.append(txvDescripcionMenu.text.toString().trim()).append("|")
                        parametro.append(spinner_NombreMenu.selectedItem.toString().trim()).append("|")
                        parametro.append(txvPrecioMenu.text.toString().trim()).append("|")
                        datos_Menu.put(num, parametro.toString())
                        println(datos_Menu.toString())
                    }
                }

    fun mostrar() {
        var position: Int = spinner_NombreMenu.selectedItemPosition
        println(position.toString())
        when (position) {
            0 -> op1()
            1 -> op2()
            2 -> op3()
            3 -> op4()
            4 -> op5()
            5 -> op6()
            6 -> op7()
        }
    }

    fun op1(){
        var des="4 Tacos, 2 refrescos"
        var pre = 90
        txvDescripcionMenu.text= des
        txvPrecioMenu.text = pre.toString()
    }

    fun op2(){
        var des="4 nachos, 4 refrescos"
        var pre = 400
        txvDescripcionMenu.text= des
        txvPrecioMenu.text = pre.toString()
    }

    fun op3(){
        var des="2 burritos, 1 refresco"
        var pre = 150
        txvDescripcionMenu.text= des
        txvPrecioMenu.text = pre.toString()
    }
    fun op4(){
        var des="2 tacos, 1 refresco"
        var pre = 180
        txvDescripcionMenu.text= des
        txvPrecioMenu.text = pre.toString()
    }

    fun op5(){
        var des="4 chiles rellenos, 1 refresco"
        var pre = 450
        txvDescripcionMenu.text= des
        txvPrecioMenu.text = pre.toString()
    }

    fun op6(){
        var des="4 chilaquiles, 4 refresco"
        var pre = 560
        txvDescripcionMenu.text= des
        txvPrecioMenu.text = pre.toString()
    }

    fun op7(){
        var des="1 Torta, 1 refresco"
        var pre = 200
        txvDescripcionMenu.text= des
        txvPrecioMenu.text = pre.toString()
    }

    fun op8(){
        var des="1 Mexican Burger, 1 refresco"
        var pre = 230
        txvDescripcionMenu.text= des
        txvPrecioMenu.text = pre.toString()
    }

    fun regresar() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
