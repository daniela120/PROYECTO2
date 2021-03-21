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
    var datos_Empleado: HashMap<Int, String> = hashMapOf()
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
                    parametro.append("DATOS EMPLEADO").append("|")
                    parametro.append(txt_CodigoEmpleado.text.toString().trim()).append("|")
                    parametro.append(txt_NombreEmpleado.text.toString().trim()).append("|")
                    parametro.append(spinner_PuestoEmpleado.selectedItem.toString().trim()).append("|")
                    datos_Empleado.put(num, parametro.toString())
                    println(datos_Empleado.toString())
                    Toast.makeText(this, "Empleado  Registrado", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    fun regresar() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}